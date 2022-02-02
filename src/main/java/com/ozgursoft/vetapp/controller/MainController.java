package com.ozgursoft.vetapp.controller;


import com.ozgursoft.vetapp.model.dto.OwnerDto;
import com.ozgursoft.vetapp.model.dto.PetDto;
import com.ozgursoft.vetapp.service.OwnerService;
import com.ozgursoft.vetapp.service.PetService;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {

    private final PetService petService;
    private final OwnerService ownerService;

    public MainController(PetService petService, OwnerService ownerService) {
        this.petService = petService;
        this.ownerService = ownerService;
    }

    @GetMapping()
    public String index(){
        return "index";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model){
        List<OwnerDto> ownerDtos = ownerService.getAllOwners();
        model.addAttribute("owners",ownerDtos);
        List<PetDto> petDtos = petService.getAllPets();
        model.addAttribute("pets",petDtos);
        return "dashboard";
    }

    @GetMapping("/search")
    public String search(@RequestParam("search") String search , Model model){
        model.addAttribute("pets",petService.getPetByName(search));
        model.addAttribute("owners",ownerService.getOwnerByNameAndSurname(search));
        return "search";
    }

    @GetMapping("/403")
    public String access(){
        return "403";
    }

}
