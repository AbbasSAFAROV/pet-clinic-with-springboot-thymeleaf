package com.ozgursoft.vetapp.service;


import com.ozgursoft.vetapp.entity.Owner;
import com.ozgursoft.vetapp.entity.Pet;
import com.ozgursoft.vetapp.exception.OwnerNotFoundException;
import com.ozgursoft.vetapp.exception.PetNotFoundException;
import com.ozgursoft.vetapp.model.dto.PetDto;
import com.ozgursoft.vetapp.model.request.PetCreateRequest;
import com.ozgursoft.vetapp.repository.OwnerRepository;
import com.ozgursoft.vetapp.repository.PetRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PetService {

    private final PetRepository petRepository;
    private final OwnerService ownerService;
    private final OwnerRepository repository;
    private final ModelMapper modelMapper;


    public PetService(PetRepository petRepository, OwnerService service, OwnerRepository repository, ModelMapper modelMapper) {
        this.petRepository = petRepository;
        this.ownerService = service;
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    public List<PetDto> getAllPets(){

        return petRepository.findAll().stream().map(pet->modelMapper.map(pet,PetDto.class)).collect(Collectors.toList());

    }

    public List<Pet> findAllPets(){
        return petRepository.findAll();
    }

    public PetDto createPet(PetCreateRequest request){
        Owner owner = ownerService.findOwnerById(request.getOwnerId());
        Pet pet = new Pet(request.getName(), request.getType(), request.getGenus(), request.getDescription(), request.getAge(), owner);
        return modelMapper.map(petRepository.save(pet),PetDto.class);
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
        return modelMapper.map(petRepository.save(updatedPet),PetDto.class);

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

}
