package com.ozgursoft.vetapp.model.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OwnerCreateRequest {
    private String nameSurname;
    private String phone;
    private String email;
    private String contact;

}
