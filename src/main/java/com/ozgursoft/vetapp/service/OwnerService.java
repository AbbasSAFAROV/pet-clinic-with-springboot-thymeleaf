package com.ozgursoft.vetapp.service;


import com.ozgursoft.vetapp.config.Converter;
import com.ozgursoft.vetapp.entity.Owner;
import com.ozgursoft.vetapp.entity.Pet;
import com.ozgursoft.vetapp.exception.OwnerNotFoundException;
import com.ozgursoft.vetapp.model.dto.OwnerDto;
import com.ozgursoft.vetapp.model.request.OwnerCreateRequest;
import com.ozgursoft.vetapp.repository.OwnerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OwnerService {

    private final OwnerRepository ownerRepository;
    private final ModelMapper modelMapper;
    private final Converter converter;

    public OwnerService(OwnerRepository ownerRepository, ModelMapper modelMapper, Converter converter) {
        this.ownerRepository = ownerRepository;
        this.modelMapper = modelMapper;
        this.converter = converter;
    }

    public List<OwnerDto> getAllOwners(){
        List<Owner> ownerList = ownerRepository.findAll();
        return converter.toOwnerDtoList(ownerList);

    }

    public OwnerDto createOwner(OwnerCreateRequest request){
        Owner owner = new Owner(request.getNameSurname(), request.getPhone(), request.getEmail(), request.getContact());
        return converter.toOwnerDto(ownerRepository.save(owner));
    }

    public OwnerDto updateOwner(OwnerCreateRequest request,Long id){

        Owner existingOwner = findOwnerById(id);
        Owner updatedOwner = new Owner(existingOwner.getId(), request.getNameSurname(), request.getPhone(), request.getEmail(), request.getContact());

        OwnerDto updatedOwnerDto = converter.toOwnerDto(ownerRepository.save(updatedOwner));

        return updatedOwnerDto;

    }

    public String deleteOwnerById(Long id){
        ownerRepository.delete(findOwnerById(id));
        return "owner deleted with id:"+id;
    }

    public OwnerDto getOwnerById(Long id){
        return modelMapper.map(findOwnerById(id),OwnerDto.class);
    }

    public Owner findOwnerById(Long id){
        return ownerRepository.findById(id).orElseThrow(()->new OwnerNotFoundException("Owner not found with id:"+id));
    }

    public List<Owner> getOwnerByNameAndSurname(String name){
        return ownerRepository.findOwnerByNameSurnameContains(name);
    }




}
