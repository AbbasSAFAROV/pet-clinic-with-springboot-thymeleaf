package com.ozgursoft.vetapp.config;

import com.ozgursoft.vetapp.entity.Owner;
import com.ozgursoft.vetapp.entity.Pet;
import com.ozgursoft.vetapp.entity.User;
import com.ozgursoft.vetapp.model.dto.OwnerDto;
import com.ozgursoft.vetapp.model.dto.PetDto;
import com.ozgursoft.vetapp.model.dto.UserDto;
import com.ozgursoft.vetapp.model.request.OwnerCreateRequest;
import com.ozgursoft.vetapp.model.request.PetCreateRequest;
import com.ozgursoft.vetapp.model.request.UserCreateRequest;
import com.ozgursoft.vetapp.service.OwnerService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Converter {



    public OwnerDto toOwnerDto(Owner owner){
        return new OwnerDto(owner.getId(), owner.getNameSurname(), owner.getPhone(), owner.getEmail(), owner.getContact(),owner.getPets());
    }

    public Owner toOwnerEntity(OwnerCreateRequest request){
        return Owner.builder()
                .nameSurname(request.getNameSurname())
                .contact(request.getContact())
                .email(request.getEmail())
                .phone(request.getPhone())
                .build();
    }

    public List<OwnerDto> toOwnerDtoList(List<Owner> owners){
        return owners.stream().map(this::toOwnerDto).collect(Collectors.toList());
    }

    /*                         PETS                            */

    public PetDto toPetDto(Pet pet){
        return new PetDto(pet.getId(), pet.getName(), pet.getType(), pet.getGenus(), pet.getDescription(), pet.getAge(), pet.getOwner().getId().toString());
    }


    public List<PetDto> toPetDtoList(List<Pet> pets){
        return pets.stream().map(this::toPetDto).collect(Collectors.toList());
    }


    /*                         USERS                              */

    public UserDto toUserDto(User user){
        return new UserDto(user.getId(), user.getName(), user.getLastName(), user.getUsername(), user.getPassword(), user.getRoles());
    }

    public User toUserEntity(UserCreateRequest request){
        return new User(request.getName(), request.getLastName(), request.getUsername(), request.getPassword(), request.getRoles());
    }

    public List<UserDto> toUserDtosList(List<User> users){
        return users.stream().map(this::toUserDto).collect(Collectors.toList());
    }

}
