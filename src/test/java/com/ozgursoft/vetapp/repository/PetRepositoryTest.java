package com.ozgursoft.vetapp.repository;

import com.ozgursoft.vetapp.entity.Owner;
import com.ozgursoft.vetapp.entity.Pet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class PetRepositoryTest {

    @Autowired
    private PetRepository petRepository;

    @Test
    void AddPetWithOwnerReturnCreated(){
        Owner owner = Owner
                .builder()
                .nameSurname("qoryooley")
                .contact("qoryooley")
                .phone("054594494")
                .email("qor@mail.com")
                .build();

        Pet pet = Pet
                .builder()
                .name("qorya")
                .type("insan")
                .genus("kangal")
                .age("12")
                .description("egitimli spring yazar")
                .owner(owner)
                .build();

        petRepository.save(pet);
    }


}