package com.ozgursoft.vetapp.service;

import com.ozgursoft.vetapp.model.dto.OwnerDto;
import com.ozgursoft.vetapp.repository.OwnerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class OwnerServiceTest {

    @Autowired
    private OwnerService ownerService;
    private OwnerRepository ownerRepository;

    @Test
    List<OwnerDto> getAllOwners(){
        return ownerService.getAllOwners();
    }

}