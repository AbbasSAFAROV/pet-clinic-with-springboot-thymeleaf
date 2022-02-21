package com.ozgursoft.vetapp.service;

import com.ozgursoft.vetapp.config.Converter;
import com.ozgursoft.vetapp.entity.User;
import com.ozgursoft.vetapp.model.dto.UserDto;
import com.ozgursoft.vetapp.repository.UserRepository;
import com.ozgursoft.vetapp.service.testSupports.UserTestSupport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest extends UserTestSupport {


    private UserRepository userRepository;
    private BCryptPasswordEncoder encoder;
    private Converter converter;
    private ModelMapper mapper;

    private UserService service;

    @BeforeEach
    void setUp() {

        userRepository = mock(UserRepository.class);
        converter = mock(Converter.class);
        mapper = mock(ModelMapper.class);
        encoder = mock(BCryptPasswordEncoder.class);

        service = new UserService(userRepository,encoder,converter,mapper);

    }

    @Test
    void testGtAllUsers_itShouldReturnUserDtoList() {

        List<User> userList = generateUserList();
        List<UserDto> userDtoList = generateUserDtoList();

        when(userRepository.findAll()).thenReturn(userList);
        when(converter.toUserDtosList(userList)).thenReturn(userDtoList);

        List<UserDto> result = service.getAllUsers();

        assertEquals(result,userDtoList);

        verify(userRepository).findAll();
        verify(converter).toUserDtosList(userList);


    }

    @Test
    void createUser() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void deleteUserById() {
    }

    @Test
    void findUserById() {
    }

    @Test
    void getUserById() {
    }

    @Test
    void getUserByUsername() {
    }

    @Test
    void getCurrentUser() {
    }

    @Test
    void loadUserByUsername() {
    }
}