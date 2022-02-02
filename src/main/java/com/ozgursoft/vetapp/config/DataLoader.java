package com.ozgursoft.vetapp.config;


import com.ozgursoft.vetapp.entity.Owner;
import com.ozgursoft.vetapp.entity.Pet;
import com.ozgursoft.vetapp.entity.Role;
import com.ozgursoft.vetapp.entity.User;
import com.ozgursoft.vetapp.model.request.UserCreateRequest;
import com.ozgursoft.vetapp.repository.OwnerRepository;
import com.ozgursoft.vetapp.repository.PetRepository;
import com.ozgursoft.vetapp.repository.UserRepository;
import com.ozgursoft.vetapp.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final UserService userService;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    public DataLoader(OwnerRepository ownerRepository, PetRepository petRepository, UserService userService, UserRepository userRepository, BCryptPasswordEncoder encoder) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.userService = userService;
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User("abbas","ahmet","admin",encoder.encode("123"), Arrays.asList(new Role("ADMIN")));
        UserCreateRequest user2 = new UserCreateRequest("ahmet","hirsi","user","123",Arrays.asList(new Role("USER")));

        Owner abbas = new Owner("abbas","05459149870","abbas@mail.com","izmir",null);
        Owner safka = new Owner("safka","05459149871","safka@mail.com","konya",null);
        Owner qorya = new Owner("qorya","05459149872","qorya@mail.com","ankara",null);

        Pet dog = new Pet("pitbul","americano","dog","has coivd-19","2",abbas);
        Pet cat = new Pet("pasha","iranian","cat","has coivd-20","2",safka);
        Pet kush = new Pet("papagan","papagn01","bird","has coivd-21","2",qorya);
        Pet kush2 = new Pet("papagan2","papagn01","bird","has coivd-22","2",qorya);


        userRepository.save(user1);
        userService.createUser(user2);
        ownerRepository.save(abbas);
        ownerRepository.save(safka);
        ownerRepository.save(qorya);
        petRepository.save(dog);
        petRepository.save(cat);
        petRepository.save(kush);
        petRepository.save(kush2);





    }
}
