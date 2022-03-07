package com.ozgursoft.vetapp.service.testSupports;

import com.ozgursoft.vetapp.entity.User;
import com.ozgursoft.vetapp.model.dto.UserDto;
import com.ozgursoft.vetapp.model.request.UserCreateRequest;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class UserTestSupport {

    public User generateUser(){
        return new User("test","test","test", Collections.emptyList());
    }

    public UserDto generateUserDto(){
        return new UserDto(1L,"test","test","test","test",Collections.emptyList());
    }

    public UserCreateRequest generateUserCreateRequest(){
        return new UserCreateRequest("test","test","test","test", null);
    }

    public List<User> generateUserList(){
        return Arrays.asList(generateUser());
    }

    public List<UserDto> generateUserDtoList(){
        return Arrays.asList(generateUserDto());
    }

}
