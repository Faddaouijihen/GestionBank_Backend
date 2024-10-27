package com.GestionBank.GestionBank.repository;

import com.GestionBank.GestionBank.entities.UserGroupe;
import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface GroupRepository extends JpaRepository<UserGroupe, Long> {
}