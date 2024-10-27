package com.GestionBank.GestionBank.services;

import com.GestionBank.GestionBank.dto.CompteBancaireDTO;
import com.GestionBank.GestionBank.entities.AccountBank;
import com.GestionBank.GestionBank.entities.CompteCourant;
import com.GestionBank.GestionBank.entities.CompteEpargne;

import java.util.List;
public interface CompteBancaireService {


    void createCompte(CompteBancaireDTO dto);

    List<CompteCourant> findAllCompteCourant();

    List<CompteEpargne> findAllCompteEpargne();

    CompteEpargne findCompteEpargne(String numCompte);

    CompteCourant findCompteCourant(String numCompte);

    AccountBank suspendCompte(String numCompte);

    AccountBank activeCompte(String numCompte);

    List<AccountBank> findAllCompteClientById(long id);

    List<AccountBank> findAllComptesCreatedByEmployeeById(long id);
}