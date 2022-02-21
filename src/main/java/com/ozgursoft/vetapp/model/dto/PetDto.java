package com.ozgursoft.vetapp.model.dto;


import lombok.*;

@Builder
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PetDto {

    private Long id;
    private String name;
    private String type;
    private String genus;
    private String description;
    private String age;
    private String ownerId;

}
