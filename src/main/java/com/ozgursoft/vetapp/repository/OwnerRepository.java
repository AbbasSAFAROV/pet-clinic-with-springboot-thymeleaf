package com.ozgursoft.vetapp.repository;

import com.ozgursoft.vetapp.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OwnerRepository extends JpaRepository<Owner,Long> {

    List<Owner> findOwnerByNameSurnameContains(String name);

}
