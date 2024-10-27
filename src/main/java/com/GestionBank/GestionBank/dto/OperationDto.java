package com.GestionBank.GestionBank.dto;

import com.GestionBank.GestionBank.entities.AccountBank;
import com.GestionBank.GestionBank.enums.TypeOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperationDto {
    private long id;
    private Date dateOperation;
    private double amount;
    private TypeOperation type;
    private AccountBank compte;
    private String  numCompte;
    private String  numCompteD;
    private String  numCompteS;

}
