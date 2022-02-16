package com.ozgursoft.vetapp.service;

import com.ozgursoft.vetapp.entity.Owner;
import com.ozgursoft.vetapp.entity.Pet;
import com.ozgursoft.vetapp.model.dto.OwnerDto;
import com.ozgursoft.vetapp.repository.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OwnerServiceTest extends TestSupport{

    private OwnerRepository repository;
    private ModelMapper mapper;

    private OwnerService service;

    @BeforeEach
    void setUp() {

        repository = mock(OwnerRepository.class);
        mapper = mock(ModelMapper.class);

        service = new OwnerService(repository,mapper);
    }

    @Test
    void test_getAllOwners() {
        // 1.veri hazırlama
        List<Owner> ownerList = generateListOwner();
        List<OwnerDto> ownerDtoList = generateListOwnerDto();
        // 2. ...
        when(repository.findAll()).thenReturn(ownerList);
        //when(ownerList).thenReturn(ownerDtoList);

        List<OwnerDto> result = service.getAllOwners();

        assertEquals(result,ownerDtoList);

        verify(repository).findAll();
        verifyNoInteractions(mapper);

    }

    @Test
    void test_allOwners() {

        List<Owner> ownerList = generateListOwner();

        when(repository.findAll()).thenReturn(ownerList);

        List<Owner> result = service.allOwners();

        assertEquals(result,ownerList);
        verify(repository).findAll();

    }

    @Test
    void createOwner() {
    }

    @Test
    void updateOwner() {
    }

    @Test
    void deleteOwnerById() {
    }

    @Test
    void getOwnerById() {
    }

    @Test
    void findOwnerById() {
    }

    @Test
    void getOwnerByNameAndSurname() {
    }
}