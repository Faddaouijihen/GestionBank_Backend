package com.GestionBank.GestionBank.repository;

import com.GestionBank.GestionBank.entities.Person;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByFirstNameContaining(String keyword);
}
