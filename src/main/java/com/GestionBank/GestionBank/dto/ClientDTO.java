package com.GestionBank.GestionBank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {
    private String firstName;
    private  String lastName;
    private String email;
    private String telephone;
    private String birthday;
}
