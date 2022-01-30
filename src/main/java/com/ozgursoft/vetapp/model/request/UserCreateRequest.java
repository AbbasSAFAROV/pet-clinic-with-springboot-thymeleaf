package com.ozgursoft.vetapp.model.request;

import com.ozgursoft.vetapp.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserCreateRequest {

    private String name;
    private String lastName;
    private String username;
    private String password;
    private Collection<Role> roles;

}
