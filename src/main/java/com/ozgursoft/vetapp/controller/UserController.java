package com.ozgursoft.vetapp.controller;


import com.ozgursoft.vetapp.model.request.UserCreateRequest;
import com.ozgursoft.vetapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserCreateRequest userCreateRequest(){
        return new UserCreateRequest();
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String getRegisterPage(){
        return "register";
    }

    @PostMapping("/register")
    public String registerPage(@ModelAttribute("user") UserCreateRequest createRequest){
        userService.createUser(createRequest);
        return "redirect:/users/login?success";
    }

    @GetMapping()
    public String getAllUses(Model model){
        model.addAttribute("users",userService.getAllUsers());
        return "users/users";
    }


    @GetMapping("/blank")
    public String getBlankPage(){
        return "blank";
    }


}
