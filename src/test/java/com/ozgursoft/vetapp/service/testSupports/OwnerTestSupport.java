package com.ozgursoft.vetapp.service.testSupports;

import com.ozgursoft.vetapp.entity.Owner;
import com.ozgursoft.vetapp.model.dto.OwnerDto;
import com.ozgursoft.vetapp.model.request.OwnerCreateRequest;

import java.util.Arrays;
import java.util.List;

public class OwnerTestSupport {

    public Owner generateOwner(){
        return new Owner("test","010101","test@test.com","test");
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
        return new OwnerCreateRequest("test","010101","test@test.com","test");
    }

    public Owner generateOwnerUpdatedRequest(Owner owner, OwnerCreateRequest request){
        return new Owner(owner.getId(), request.getNameSurname(), owner.getPhone(), owner.getEmail(), owner.getContact());
    }

    public List<Owner> generateListOwner(){
        return Arrays.asList(generateOwner());
    }
    public List<OwnerDto> generateListOwnerDto(){
        return Arrays.asList(generateOwnerDto());
    }

}
