package com.ozgursoft.vetapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private String genus;
    private String description;
    private String age;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY )
    private Owner owner;

    public Pet(String name, String type, String genus, String description, String age, Owner owner) {
        this.name = name;
        this.type = type;
        this.genus = genus;
        this.description = description;
        this.age = age;
        this.owner = owner;
    }

    /*public Pet(String name, String type, String genus, String description, String age) {
        this.name = name;
        this.type = type;
        this.genus = genus;
        this.description = description;
        this.age = age;
    }

    public Pet(Long id, String name, String type, String genus, String description, String age) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.genus = genus;
        this.description = description;
        this.age = age;
    }*/

}
