package com.ozgursoft.vetapp.service;

import com.ozgursoft.vetapp.entity.Owner;
import com.ozgursoft.vetapp.entity.Pet;
import com.ozgursoft.vetapp.model.dto.OwnerDto;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestSupport {

    public Owner generateOwner(){
        return Owner.builder()
                .id(1L)
                .nameSurname("test")
                .email("test@mail.com")
                .contact("test-contact")
                .phone("test")
                .build();
    }

    public OwnerDto generateOwnerDto(){
        return OwnerDto.builder()
                .id(1L)
                .nameSurname("test")
                .email("test@mail.com")
                .contact("test-contact")
                .phone("test")
                .build();
    }

    public List<Owner> generateListOwner(){
        return Arrays.asList(generateOwner());
    }
    public List<OwnerDto> generateListOwnerDto(){
        return Arrays.asList(generateOwnerDto());
    }

}
