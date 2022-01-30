package com.ozgursoft.vetapp.service;


import com.ozgursoft.vetapp.entity.Owner;
import com.ozgursoft.vetapp.exception.OwnerNotFoundException;
import com.ozgursoft.vetapp.model.dto.OwnerDto;
import com.ozgursoft.vetapp.model.request.OwnerCreateRequest;
import com.ozgursoft.vetapp.repository.OwnerRepository;
import com.ozgursoft.vetapp.repository.PetRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OwnerService {

    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final ModelMapper modelMapper;

    public OwnerService(OwnerRepository ownerRepository, PetRepository petRepository, ModelMapper modelMapper) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.modelMapper = modelMapper;
    }

    public List<OwnerDto> getAllOwners(){
        return ownerRepository.findAll().stream().map(owner->modelMapper.map(owner, OwnerDto.class)).collect(Collectors.toList());
    }

    public OwnerDto createOwner(OwnerCreateRequest request){
        Owner owner = modelMapper.map(request,Owner.class);
        return modelMapper.map(ownerRepository.save(owner),OwnerDto.class);
    }

    public OwnerDto updateOwner(OwnerCreateRequest request,Long id){

        Owner existingOwner = findOwnerById(id);
        Owner updatedOwner = new Owner();
        updatedOwner.setId(existingOwner.getId());
        updatedOwner.setNameSurname(request.getNameSurname());
        updatedOwner.setEmail(request.getEmail());
        updatedOwner.setPhone(request.getPhone());
        updatedOwner.setContact(request.getContact());
        return modelMapper.map(ownerRepository.save(updatedOwner),OwnerDto.class);

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




}
