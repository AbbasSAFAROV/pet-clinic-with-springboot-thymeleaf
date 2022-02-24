package com.ozgursoft.vetapp.service;


import com.ozgursoft.vetapp.config.Converter;
import com.ozgursoft.vetapp.entity.Owner;
import com.ozgursoft.vetapp.entity.Pet;
import com.ozgursoft.vetapp.exception.PetNotFoundException;
import com.ozgursoft.vetapp.model.dto.PetDto;
import com.ozgursoft.vetapp.model.request.PetCreateRequest;
import com.ozgursoft.vetapp.repository.PetRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    private final PetRepository petRepository;
    private final OwnerService ownerService;
    private final ModelMapper modelMapper;
    private final Converter converter;



    public PetService(PetRepository petRepository, OwnerService service, ModelMapper modelMapper, Converter converter) {
        this.petRepository = petRepository;
        this.ownerService = service;
        this.modelMapper = modelMapper;
        this.converter = converter;
    }

    public List<PetDto> getAllPets(){
        return converter.toPetDtoList(petRepository.findAll());
    }

    public List<Pet> findAllPets(){
        return petRepository.findAll();
    }

    public PetDto createPet(PetCreateRequest request){
        Owner owner = ownerService.findOwnerById(request.getOwnerId());
        Pet pet = new Pet(request.getName(), request.getType(), request.getGenus(), request.getDescription(), request.getAge(), owner);
        Pet savedPet = petRepository.save(pet);
        PetDto petDto = converter.toPetDto(savedPet);
        return petDto;
    }

    public PetDto updatePet(PetCreateRequest request,Long id){

        Pet existingPet = findPetById(id);
        Pet updatedPet = Pet.builder()
                .id(existingPet.getId())
                .owner(existingPet.getOwner())
                .name(request.getName())
                .age(request.getAge())
                .description(request.getDescription())
                .genus(request.getGenus())
                .type(request.getType())
                .build();

        return converter.toPetDto(petRepository.save(updatedPet));

    }

    public String deletePetById(Long id){
        petRepository.delete(findPetById(id));
        return "deleted pet id:"+id;
    }

    public PetDto getPetById(Long id){
        return modelMapper.map(findPetById(id),PetDto.class);
    }

    public Pet findPetById(Long id){
        return petRepository.findById(id).orElseThrow(()->new PetNotFoundException("Pet not found id:"+id));
    }

    public List<Pet> getPetByName(String name){
        return petRepository.findPetByNameContains(name);
    }

}
