package com.ozgursoft.vetapp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameSurname;
    private String phone;
    private String email;
    private String contact;
    @OneToMany(mappedBy = "owner" , cascade = CascadeType.ALL)
    private List<Pet> pets;

    public Owner(String nameSurname, String phone, String email, String contact, List<Pet> pets) {
        this.nameSurname = nameSurname;
        this.phone = phone;
        this.email = email;
        this.contact = contact;
        this.pets = pets;
    }

    public Owner(Long id, String nameSurname, String phone, String email, String contact) {
        this.id = id;
        this.nameSurname = nameSurname;
        this.phone = phone;
        this.email = email;
        this.contact = contact;
    }

    public Owner(String nameSurname, String phone, String email, String contact) {
        this.nameSurname = nameSurname;
        this.phone = phone;
        this.email = email;
        this.contact = contact;
    }

}
