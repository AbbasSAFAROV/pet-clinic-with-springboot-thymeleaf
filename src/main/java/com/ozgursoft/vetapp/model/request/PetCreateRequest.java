package com.ozgursoft.vetapp.model.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetCreateRequest {

    private String name;
    private String type;
    private String genus;
    private String description;
    private String age;
    private Long ownerId;

}
