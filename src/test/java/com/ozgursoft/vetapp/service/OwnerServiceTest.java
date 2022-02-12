package com.ozgursoft.vetapp.service;

import com.ozgursoft.vetapp.entity.Owner;
import com.ozgursoft.vetapp.repository.OwnerRepository;
import com.ozgursoft.vetapp.repository.PetRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


class OwnerServiceTest {

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    ModelMapper modelMapper;

    @InjectMocks
    OwnerService ownerService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);

        when(ownerService.allOwners()).thenReturn(prepareOwnerDtos());
    }
  @Test
    public void testGetAllOwners(){
        assertEquals(ownerService.getAllOwners().size(),2);
        //assertEquals(ownerService.getAllOwners().get(0).getEmail(), "test");
        //assertEquals(ownerService.getAllOwners().get(1).getNameSurname(), "test2");

    }


    private List<Owner> prepareOwnerDtos(){
        return Arrays.asList(Owner.builder().id(1L).email("test").build(), Owner.builder().id(2L).nameSurname("test2").build());
    }


}