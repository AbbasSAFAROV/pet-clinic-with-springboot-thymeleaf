package com.ozgursoft.vetapp.api;


import com.ozgursoft.vetapp.entity.Owner;
import com.ozgursoft.vetapp.model.dto.OwnerDto;
import com.ozgursoft.vetapp.model.request.OwnerCreateRequest;
import com.ozgursoft.vetapp.service.OwnerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/owners")
public class OwnerRestController {

    private final OwnerService ownerService;

    public OwnerRestController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping()
    public ResponseEntity<List<OwnerDto>> getAllOwners(){
        return ResponseEntity.ok(ownerService.getAllOwners());
    }

    @PostMapping()
    public ResponseEntity<OwnerDto> createOwner(@RequestBody OwnerCreateRequest request){
        return new ResponseEntity<OwnerDto>(ownerService.createOwner(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OwnerDto> updateOwner(@RequestBody OwnerCreateRequest request,@PathVariable Long id){
        return new ResponseEntity<>(ownerService.updateOwner(request,id),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOwnerById(@PathVariable Long id){
        return ResponseEntity.ok(ownerService.deleteOwnerById(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OwnerDto> getOwnerById(@PathVariable Long id){
        return new ResponseEntity<>(ownerService.getOwnerById(id),HttpStatus.OK);
    }


}
