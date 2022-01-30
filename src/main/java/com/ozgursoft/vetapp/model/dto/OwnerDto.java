package com.ozgursoft.vetapp.model.dto;

import com.ozgursoft.vetapp.entity.Pet;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OwnerDto {

    private Long id;
    private String nameSurname;
    private String phone;
    private String email;
    private String contact;
    private List<Pet> pets;

}
