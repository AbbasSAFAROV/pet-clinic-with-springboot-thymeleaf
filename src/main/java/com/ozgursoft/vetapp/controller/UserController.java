package com.ozgursoft.vetapp.controller;


import com.ozgursoft.vetapp.model.request.UserCreateRequest;
import com.ozgursoft.vetapp.service.RoleService;
import com.ozgursoft.vetapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final RoleService roleService;

    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
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

    @GetMapping("/create")
    public String createUser(Model model){
        model.addAttribute("roles",roleService.getAllRoles());
        return "users/addUser";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute("user") UserCreateRequest request){
        userService.createUser(request);
        return "redirect:/dashboard?success";
    }

    @GetMapping("/update/{id}")
    public String updateUser(@PathVariable Long id, Model model){
        model.addAttribute("user",userService.getUserById(id));
        model.addAttribute("roles",userService.getUserById(id).getRoles());
        return "users/updateUser";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute("user") UserCreateRequest request){
        userService.updateUser(request,id);
        return "redirect:/users?success";
    }

    @GetMapping("/detail/{id}")
    public String userDetail(@PathVariable Long id, Model model){
        model.addAttribute("user",userService.findUserById(id));
        return "users/detail";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id){
        userService.deleteUserById(id);
        return "redirect:/users?success";
    }

    @GetMapping("/blank")
    public String getBlankPage(){
        return "blank";
    }


}
