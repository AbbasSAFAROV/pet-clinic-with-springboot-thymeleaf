package com.ozgursoft.vetapp.model.request;


import lombok.*;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OwnerCreateRequest {
    private String nameSurname;
    private String phone;
    private String email;
    private String contact;



}
