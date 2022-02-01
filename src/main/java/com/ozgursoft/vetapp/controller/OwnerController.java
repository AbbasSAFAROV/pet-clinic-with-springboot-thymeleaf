package com.ozgursoft.vetapp.controller;

import com.ozgursoft.vetapp.model.dto.OwnerDto;
import com.ozgursoft.vetapp.model.request.OwnerCreateRequest;
import com.ozgursoft.vetapp.service.OwnerService;
import com.ozgursoft.vetapp.service.PetService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    private final PetService petService;
    private final OwnerService ownerService;
    private final ModelMapper modelMapper;

    public OwnerController(PetService petService, OwnerService ownerService, ModelMapper modelMapper) {
        this.petService = petService;
        this.ownerService = ownerService;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute("owner")
    public OwnerCreateRequest ownerCreateRequest(){
        return new OwnerCreateRequest();
    }

    @GetMapping()
    public String getAllOwners(Model model){

        List<OwnerDto> ownerDtos = ownerService.getAllOwners();
        model.addAttribute("owners",ownerDtos);
        return "owners/owners";

    }

    @GetMapping("/add")
    public String getOwnerAddPage(){
        return "owners/addOwner";
    }

    @PostMapping("/add")
    public String ownerAddPage(@ModelAttribute("owner") OwnerCreateRequest ownerCreateRequest){
        ownerService.createOwner(ownerCreateRequest);
        return "redirect:/owners?success";
    }

    @GetMapping("/update/{id}")
    public String getOwnerEditPage(@PathVariable("id") Long id, Model model){
        OwnerDto ownerDto = ownerService.getOwnerById(id);
        model.addAttribute("owner",ownerDto);
        return "owners/updateOwner";
    }

    @PostMapping("/update/{id}")
    public String ownerEditPage(@PathVariable("id") Long id, @ModelAttribute("owner") OwnerCreateRequest request){
        ownerService.updateOwner(request,id);
        return "redirect:/owners";
    }

    @GetMapping("/detail?/{id}")
    public String ownerDetail(@PathVariable Long id, Model model){
        model.addAttribute("owner",ownerService.getOwnerById(id));
        model.addAttribute("pets",petService.getPetsByOwnerId(id));
        return "owners/ownerDetail";
    }

    @GetMapping("/detail/{id}")
    public String ownerDetailPage(@PathVariable Long id, Model model){
        model.addAttribute("owner",ownerService.getOwnerById(id));
        model.addAttribute("pets",petService.getPetsByOwnerId(id));
        return "owners/detail";
    }

    @GetMapping("/delete/{id}")
    public String deleteOwnerById(@PathVariable("id") Long id){
        ownerService.deleteOwnerById(id);
        return "redirect:/owners";
    }


}
