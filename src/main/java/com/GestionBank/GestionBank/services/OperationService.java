package com.GestionBank.GestionBank.services;

import com.GestionBank.GestionBank.dto.OperationDto;
import com.GestionBank.GestionBank.entities.AccountBank;
import com.GestionBank.GestionBank.entities.Operation;

import java.util.List;

public interface OperationService {
  AccountBank effectuerVersement(String numCompte, double montant);
  AccountBank effectuerRetrait(String numCompte, double montant);
  List<Operation> findByClientNumCompte(String  numCompte);
  AccountBank virementFromOneCompteAToCompteB(String numCompteSource, String numCompteDestination, double montant);
}