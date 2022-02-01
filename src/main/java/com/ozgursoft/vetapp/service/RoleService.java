package com.ozgursoft.vetapp.service;


import com.ozgursoft.vetapp.entity.Role;
import com.ozgursoft.vetapp.exception.RoleNoFoundException;
import com.ozgursoft.vetapp.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    private final RoleRepository repository;

    public RoleService(RoleRepository repository) {
        this.repository = repository;
    }

    public List<Role> getAllRoles(){
        return repository.findAll();
    }

    public Role createRole(Role role){
        return repository.save(role);
    }

    public Role findRoleById(Long id){
        return repository.findById(id).orElseThrow(()->new RoleNoFoundException("role not found id:"+id));
    }


}
