package com.GestionBank.GestionBank.repository;

import com.GestionBank.GestionBank.entities.AccountBank;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Transactional

public interface CompteBancaireRepository extends JpaRepository<AccountBank,Long> {

Optional<AccountBank>findByNumCompte(@Param("numCompte") String numCompte);



}
