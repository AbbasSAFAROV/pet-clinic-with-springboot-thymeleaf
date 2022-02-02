package com.ozgursoft.vetapp.repository;

import com.ozgursoft.vetapp.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet,Long> {

    List<Pet> findPetByNameContains(String name);

}
