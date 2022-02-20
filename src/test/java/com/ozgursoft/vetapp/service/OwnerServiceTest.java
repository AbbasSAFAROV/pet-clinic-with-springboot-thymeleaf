package com.ozgursoft.vetapp.service;

import com.ozgursoft.vetapp.config.Converter;
import com.ozgursoft.vetapp.entity.Owner;
import com.ozgursoft.vetapp.model.dto.OwnerDto;
import com.ozgursoft.vetapp.model.dto.UserDto;
import com.ozgursoft.vetapp.model.request.OwnerCreateRequest;
import com.ozgursoft.vetapp.repository.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OwnerServiceTest extends TestSupport{

    private OwnerRepository repository;
    private ModelMapper mapper;
    private OwnerService service;
    private Converter converter;

    @BeforeEach
    void setUp() {
        repository = mock(OwnerRepository.class);
        converter = mock(Converter.class);
        mapper = mock(ModelMapper.class);

        service = new OwnerService(repository,mapper, converter);
    }

    @Test
    void testGetAllOwners_itShouldReturnListOfOwnerDto() {

        // 1.veri hazırlama
        List<Owner> ownerList = generateListOwner();
        List<OwnerDto> ownerDtoList = generateListOwnerDto();
        // 2. ...
        when(repository.findAll()).thenReturn(ownerList);
        when(converter.toOwnerDtoList(ownerList)).thenReturn(ownerDtoList);

        List<OwnerDto> result = service.getAllOwners();

        assertEquals(result,ownerDtoList);

        verify(repository).findAll();
        verify(converter).toOwnerDtoList(ownerList);
        verifyNoInteractions(mapper);

    }

    @Test
    void testCreateOwner_whenCalledCreateOwnerRequest_itShouldReturnOwnerDto() {

        OwnerCreateRequest request = generateOwnerCreateRequest();
        Owner owner = generateOwner();
        OwnerDto ownerDto = generateOwnerDto();

        when(repository.save(owner)).thenReturn(owner);
        when(converter.toOwnerDto(owner)).thenReturn(ownerDto);

        OwnerDto result = service.createOwner(request);

        assertEquals(result,ownerDto);

        verify(repository).save(owner);
        verify(converter).toOwnerDto(owner);

    }

    @Test
    void testUpdateOwner_whenCalledValidRequest_shouldReturnOwnerDto() {

        OwnerCreateRequest request = generateOwnerCreateRequest();
        OwnerDto ownerDto = generateOwnerDto();
        Owner owner = generateOwner();
        Owner updatedOwner = generateOwnerUpdatedRequest(owner,request);

        when(repository.findById(1L)).thenReturn(Optional.of(owner));
        when(repository.save(updatedOwner)).thenReturn(updatedOwner);
        when(converter.toOwnerDto(updatedOwner)).thenReturn(ownerDto);

        OwnerDto result = service.updateOwner(request,1L);

        assertEquals(result,ownerDto);

        verify(repository).findById(1L);
        verify(repository).save(updatedOwner);
        verify(converter).toOwnerDto(updatedOwner);

    }

    @Test
    void testDeleteOwnerById_whenCalledWithValidId_itShouldReturnString() {

        Owner owner = generateOwner();

        when(repository.findById(anyLong())).thenReturn(Optional.of(owner));

        String result = service.deleteOwnerById(1L);

        assertEquals("owner deleted with id:1",result);

        verify(repository).findById(1L);

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