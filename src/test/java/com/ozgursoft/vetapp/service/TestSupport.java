package com.ozgursoft.vetapp.service;

import com.ozgursoft.vetapp.entity.Owner;
import com.ozgursoft.vetapp.model.dto.OwnerDto;
import com.ozgursoft.vetapp.model.request.OwnerCreateRequest;

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

    public OwnerCreateRequest generateOwnerCreateRequest(){
        return OwnerCreateRequest.builder()
                .nameSurname("test")
                .contact("test-contact")
                .email("test@mail.com")
                .phone("11111")
                .build();
    }

    public List<Owner> generateListOwner(){
        return Arrays.asList(generateOwner());
    }
    public List<OwnerDto> generateListOwnerDto(){
        return Arrays.asList(generateOwnerDto());
    }

}
