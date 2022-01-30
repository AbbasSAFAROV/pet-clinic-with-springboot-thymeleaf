package com.ozgursoft.vetapp.controller;


import com.ozgursoft.vetapp.entity.Owner;
import com.ozgursoft.vetapp.entity.Pet;
import com.ozgursoft.vetapp.model.dto.OwnerDto;
import com.ozgursoft.vetapp.model.dto.PetDto;
import com.ozgursoft.vetapp.model.request.PetCreateRequest;
import com.ozgursoft.vetapp.service.OwnerService;
import com.ozgursoft.vetapp.service.PetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pets")
public class PetController {

    private final PetService petService;
    private final OwnerService ownerService;

    public PetController(PetService petService, OwnerService ownerService) {
        this.petService = petService;
        this.ownerService = ownerService;
    }

    @ModelAttribute("pet")
    public PetCreateRequest createRequest(){
        return new PetCreateRequest();
    }

    @GetMapping()
    public String getAllPets(Model model){

        List<PetDto> petDtos = petService.getAllPets();
        List<Pet> pets = petService.findAllPets();
        List<OwnerDto> ownerDtos = ownerService.getAllOwners();
        model.addAttribute("pets",pets);
        return "pets/pets";
    }

    @GetMapping("/add")
    public String getPetAddPage(Model model){
        List<OwnerDto> ownerDtos = ownerService.getAllOwners();
        model.addAttribute("owners",ownerDtos);
        return "pets/addPet";

    }

    @PostMapping("/add")
    public String petAddPage(@ModelAttribute("pet") PetCreateRequest createRequest,Model model){
        List<OwnerDto> ownerDtos = ownerService.getAllOwners();
        model.addAttribute("owners",ownerDtos);
        petService.createPet(createRequest);
        return "redirect:/pets";
    }

    @GetMapping("/update/{id}")
    public String getPetEditPage(@PathVariable Long id, Model model){
        Owner owner = ownerService.findOwnerById(petService.findPetById(id).getOwner().getId());
        model.addAttribute("pet",petService.getPetById(id));
        model.addAttribute("owner",owner);
        return "pets/petUpdate";
    }

    @PostMapping("/update/{id}")
    public String updatePet(@PathVariable Long id, @ModelAttribute("pet") PetCreateRequest createRequest){
        petService.updatePet(createRequest,id);
        return "redirect:/pets";
    }

    @GetMapping("/delete/{id}")
    public String deletePetById(@PathVariable Long id){
        petService.deletePetById(id);
        return "redirect:/pets";
    }


}
