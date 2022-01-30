package com.ozgursoft.vetapp.model.dto;


import com.ozgursoft.vetapp.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {

    private Long id;
    private String name;
    private String lastName;
    private String username;
    private String password;
    private Collection<Role> roles;

}
