package com.ozgursoft.vetapp.config;


import com.ozgursoft.vetapp.entity.Owner;
import com.ozgursoft.vetapp.model.dto.OwnerDto;
import com.ozgursoft.vetapp.model.request.OwnerCreateRequest;
import org.springframework.stereotype.Component;

import java.util.Arrays;
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

}
