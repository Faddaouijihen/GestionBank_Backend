package com.GestionBank.GestionBank.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserGroupe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Change AUTO to IDENTITY
    private long id;

    private String nomGroup;

    @ManyToMany(mappedBy = "groups")
    private Set<Employee> employees = new HashSet<>();
}
