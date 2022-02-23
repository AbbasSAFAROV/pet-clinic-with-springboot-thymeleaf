package com.ozgursoft.vetapp.service;

import com.ozgursoft.vetapp.config.Converter;
import com.ozgursoft.vetapp.entity.Owner;
import com.ozgursoft.vetapp.entity.Pet;
import com.ozgursoft.vetapp.model.dto.PetDto;
import com.ozgursoft.vetapp.model.request.PetCreateRequest;
import com.ozgursoft.vetapp.repository.PetRepository;
import com.ozgursoft.vetapp.service.testSupports.PetTestSupport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PetServiceTest extends PetTestSupport {

    private PetRepository repository;
    private Converter converter;
    private OwnerService ownerService;
    private ModelMapper modelMapper;

    private PetService service;

    @BeforeEach
    void setUp() {
        repository = mock(PetRepository.class);
        converter = mock(Converter.class);
        modelMapper = mock(ModelMapper.class);
        ownerService = mock(OwnerService.class);

        service = new PetService(repository,ownerService,modelMapper,converter);
    }

    @Test
    void testGetAllPets_itShouldReturnPetDtoList() {

        List<Pet> petList = generatePetList();
        List<PetDto> petDtoList = generatePetDtoList();

        when(repository.findAll()).thenReturn(petList);
        when(converter.toPetDtoList(petList)).thenReturn(petDtoList);

        List<PetDto> result = service.getAllPets();

        assertEquals(petDtoList,result);

        verify(repository).findAll();
        verify(converter).toPetDtoList(petList);

    }

    @Test
    void findAllPets() {
    }

    @Test
    void testCreatePet_whenCalledValidRequest_isShouldReturnPetDto() {

        Owner owner = generateOwner();
        Pet pet =  generatePet();
        Pet pe1 = new Pet();
        PetDto petDto = generatePetDto();
        PetCreateRequest request = generatePetCreateRequest();

        when(ownerService.findOwnerById(request.getOwnerId())).thenReturn(owner);
        when(repository.save(pet)).thenReturn(pet);
        when(converter.toPetDto(pet)).thenReturn(petDto);

        PetDto result = service.createPet(request);

        assertEquals(result,petDto);

        verify(ownerService).findOwnerById(1L);
        verify(repository).save(pet);
        verify(converter).toPetDto(pet);

    }

    @Test
    void updatePet() {
    }

    @Test
    void deletePetById() {
    }

    @Test
    void getPetById() {
    }

    @Test
    void findPetById() {
    }

    @Test
    void getPetByName() {
    }
}