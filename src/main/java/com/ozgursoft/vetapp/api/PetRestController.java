package com.ozgursoft.vetapp.api;


import com.ozgursoft.vetapp.entity.Pet;
import com.ozgursoft.vetapp.model.dto.PetDto;
import com.ozgursoft.vetapp.model.request.PetCreateRequest;
import com.ozgursoft.vetapp.service.OwnerService;
import com.ozgursoft.vetapp.service.PetService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pets")
public class PetRestController {

    private final PetService petService;
    private final OwnerService ownerService;
    private final ModelMapper modelMapper;

    public PetRestController(PetService petService, OwnerService ownerService, ModelMapper modelMapper) {
        this.petService = petService;
        this.ownerService = ownerService;
        this.modelMapper = modelMapper;
    }

    @GetMapping()
    public ResponseEntity<List<PetDto>> getAllPets(){
        return new ResponseEntity<>(petService.getAllPets(),HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<PetDto> createPet(@RequestBody PetCreateRequest request){
        return new ResponseEntity<>(petService.createPet(request), HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<PetDto> updatePet(@RequestBody PetCreateRequest request,@PathVariable Long id){
        return new ResponseEntity<>(petService.updatePet(request,id),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePetById(@PathVariable Long id){
        return ResponseEntity.ok(petService.deletePetById(id));
    }


}
