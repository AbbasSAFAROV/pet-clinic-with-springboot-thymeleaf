package com.ozgursoft.vetapp.service.testSupports;

import com.ozgursoft.vetapp.entity.Pet;
import com.ozgursoft.vetapp.model.dto.PetDto;
import com.ozgursoft.vetapp.model.request.PetCreateRequest;

import java.util.Arrays;
import java.util.List;

public class PetTestSupport extends OwnerTestSupport{


    public Pet generatePet(){
        return new Pet("test","test-type","test-genus","test-desc","age",generateOwner());
    }

    public PetDto generatePetDto(){
        return new PetDto(101L,"test","test-type","test-genus","test-desc","age","1");
    }

    public PetCreateRequest generatePetCreateRequest(){
        return new PetCreateRequest("test","test","test","test","test",1L);
    }

    public List<Pet> generatePetList(){
        return Arrays.asList(generatePet());
    }

    public List<PetDto> generatePetDtoList(){
        return Arrays.asList(generatePetDto());
    }

}
