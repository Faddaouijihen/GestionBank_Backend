package com.GestionBank.GestionBank.dto;

import com.GestionBank.GestionBank.enums.AccountStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
@Data
@AllArgsConstructor

public class CompteBancaireDTO {
    private String numCompte;
    private  String devis;
    private double balance;
    private Date createdAt;
    private AccountStatus status;
    private double tauxInteret;
    private double decouvert;
    private long clientId;
}
