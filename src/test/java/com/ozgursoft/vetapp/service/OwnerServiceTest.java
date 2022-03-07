package com.ozgursoft.vetapp.service;

import com.ozgursoft.vetapp.config.Converter;
import com.ozgursoft.vetapp.entity.Owner;
import com.ozgursoft.vetapp.exception.OwnerNotFoundException;
import com.ozgursoft.vetapp.model.dto.OwnerDto;
import com.ozgursoft.vetapp.model.request.OwnerCreateRequest;
import com.ozgursoft.vetapp.repository.OwnerRepository;
import com.ozgursoft.vetapp.service.testSupports.OwnerTestSupport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OwnerServiceTest extends OwnerTestSupport {

    private OwnerRepository repository;
    private ModelMapper mapper;
    private OwnerService service;
    private Converter converter;

    @BeforeEach
    void setUp() {
        repository = mock(OwnerRepository.class);
        converter = mock(Converter.class);
        mapper = mock(ModelMapper.class);

        service = new OwnerService(repository, converter);
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
    void testUpdateOwner_whenCalledValidRequest_itShouldReturnOwnerDto() {

        OwnerCreateRequest request = generateOwnerCreateRequest();
        OwnerDto ownerDto = generateOwnerDto();
        Owner owner = generateOwner();
        Owner owner1 = generateOwner();
        Owner updatedOwner = generateOwnerUpdatedRequest(owner,request);

        when(repository.findById(1L)).thenReturn(Optional.of(owner));
        when(repository.save(updatedOwner)).thenReturn(updatedOwner);
        when(converter.toOwnerDto(updatedOwner)).thenReturn(ownerDto);

        OwnerDto result = service.updateOwner(request,1L);

        assertEquals(result,ownerDto);

        verify(repository).findById(1L);
        verify(repository).save(updatedOwner);
        //verify(repository).save(updatedOwner);
        verify(converter).toOwnerDto(updatedOwner);

    }

    @Test
    void testUpdateOwner_whenCalledWithInvalidRequest_itShouldReturnOwnerDto() {

        OwnerCreateRequest request = generateOwnerCreateRequest();

        when(repository.findById(anyLong())).thenThrow(OwnerNotFoundException.class);

        assertThrows(OwnerNotFoundException.class,()->service.updateOwner(request,anyLong()));

        verify(repository).findById(anyLong());
        verifyNoInteractions(converter);

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
    void testDeleteOwnerById_whenCalledWithInvalidId_itShouldThrowNotFoundException() {

        when(repository.findById(anyLong())).thenThrow(OwnerNotFoundException.class);

        assertThrows(OwnerNotFoundException.class,()->service.deleteOwnerById(anyLong()));

        verify(repository).findById(anyLong());
        verifyNoInteractions(converter);

    }

    @Test
    void testGetOwnerById_whenCalledWithExistId_itShouldReturnOwnerDto() {

        Owner owner = generateOwner();
        OwnerDto ownerDto = generateOwnerDto();

        when(repository.findById(anyLong())).thenReturn(Optional.of(owner));
        when(converter.toOwnerDto(owner)).thenReturn(ownerDto);

        OwnerDto result = service.getOwnerById(1L);

        assertEquals(result,ownerDto);

        verify(repository).findById(1L);
        verify(converter).toOwnerDto(owner);

    }

    @Test
    void testGetOwnerById_whenCalledWithInvalidId_itShouldThrowNotFoundException() {

        when(repository.findById(anyLong())).thenThrow(OwnerNotFoundException.class);

        assertThrows(OwnerNotFoundException.class,()->service.getOwnerById(anyLong()));

        verify(repository).findById(anyLong());
        verifyNoInteractions(converter);

    }

    @Test
    void testFindOwnerById_whenCalledWithExistId_itShouldReturnOwner() {

        Owner owner = generateOwner();

        when(repository.findById(anyLong())).thenReturn(Optional.of(owner));

        Owner result = service.findOwnerById(anyLong());

        assertEquals(result,owner);

        verify(repository).findById(anyLong());

    }

    @Test
    void testFindOwnerById_whenCalledWithInvalidId_itShouldThrowException() {

        when(repository.findById(anyLong())).thenThrow(OwnerNotFoundException.class);
        assertThrows(OwnerNotFoundException.class,()->service.findOwnerById(anyLong()));

        verify(repository).findById(anyLong());
        verifyNoInteractions(converter);
    }

    @Test
    void getOwnerByNameAndSurname() {
    }
}