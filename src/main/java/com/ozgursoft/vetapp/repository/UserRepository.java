package com.ozgursoft.vetapp.repository;

import com.ozgursoft.vetapp.entity.Owner;
import com.ozgursoft.vetapp.entity.User;
import com.ozgursoft.vetapp.model.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    User findUserByUsername(String name);

}
