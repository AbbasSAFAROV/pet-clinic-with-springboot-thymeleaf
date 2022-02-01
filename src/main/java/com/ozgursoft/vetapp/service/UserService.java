package com.ozgursoft.vetapp.service;


import com.ozgursoft.vetapp.entity.Role;
import com.ozgursoft.vetapp.entity.User;
import com.ozgursoft.vetapp.exception.UserNotFoundException;
import com.ozgursoft.vetapp.model.dto.UserDto;
import com.ozgursoft.vetapp.model.request.UserCreateRequest;
import com.ozgursoft.vetapp.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;
    private final ModelMapper modelMapper;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder encoder, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.encoder = encoder;
        this.modelMapper = modelMapper;
    }

    public List<UserDto> getAllUsers(){
        return userRepository.findAll().stream().map(user->modelMapper.map(user,UserDto.class)).collect(Collectors.toList());
    }

    public UserDto createUser(UserCreateRequest request){
        //Role veterinary = new Role("USER");
        User user = new User(request.getName(), request.getLastName(), request.getUsername(),encoder.encode(request.getPassword()), request.getRoles());
        user.setRoles(Arrays.asList(new Role("USER")));
        return modelMapper.map(userRepository.save(user),UserDto.class);
    }

    public UserDto updateUser(UserCreateRequest request , Long id){

        User existUser = findUserById(id);
        User updatedUser = new User(request.getName(), request.getLastName(), request.getUsername(), request.getPassword(), request.getRoles());
        return modelMapper.map(updatedUser,UserDto.class);
    }

    public String deleteUserById(Long id){
        userRepository.delete(findUserById(id));
        return "user deleted id:"+id;
    }

    public User findUserById(Long id){
        return userRepository.findById(id).orElseThrow(()->new UserNotFoundException("user not found id:"+id));
    }

    public UserDto getUserById(Long id){
        return modelMapper.map(findUserById(id),UserDto.class);
    }

    public User getUserByUsername(String username){
        return userRepository.findUserByUsername(username);
    }

    public User getCurrentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken))
            return getUserByUsername(authentication.getName());
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException("Username or Password is wrong repeat again ...");
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),mapRoles(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRoles(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }



}
