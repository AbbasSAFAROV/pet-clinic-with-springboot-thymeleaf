package com.ozgursoft.vetapp.api;


import com.ozgursoft.vetapp.model.dto.UserDto;
import com.ozgursoft.vetapp.model.request.UserCreateRequest;
import com.ozgursoft.vetapp.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@RequestBody UserCreateRequest request){
        return new ResponseEntity<>(userService.createUser(request),HttpStatus.CREATED);
    }

}
