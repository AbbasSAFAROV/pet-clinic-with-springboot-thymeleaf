package com.ozgursoft.vetapp.repository;

import com.ozgursoft.vetapp.entity.Role;
import com.ozgursoft.vetapp.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void addUserWithRoleReturnCreated(){

        Role admin = Role.builder()
                .name("ADMIN")
                .build();

        User user = User.builder()
                .username("admin")
                .password("admin")
                .roles(Collections.singleton(admin))
                .build();

        userRepository.save(user);


    }


}