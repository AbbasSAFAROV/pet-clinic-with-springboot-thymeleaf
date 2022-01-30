package com.ozgursoft.vetapp.repository;

import com.ozgursoft.vetapp.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet,Long> {
}
