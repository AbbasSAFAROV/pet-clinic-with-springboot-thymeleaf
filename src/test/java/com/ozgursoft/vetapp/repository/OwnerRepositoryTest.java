package com.ozgursoft.vetapp.repository;

import com.ozgursoft.vetapp.entity.Owner;
import com.ozgursoft.vetapp.entity.Pet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OwnerRepositoryTest {

    @Autowired
    private OwnerRepository ownerRepository;

    @Test
    void addOwnerMustReturnCreated(){

        Owner owner = Owner
                .builder()
                .nameSurname("qoryooley")
                .contact("qoryooley")
                .phone("054594494")
                .email("qor@mail.com")
                .build();

        ownerRepository.save(owner);

    }

}