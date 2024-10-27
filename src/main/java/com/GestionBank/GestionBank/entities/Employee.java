package com.GestionBank.GestionBank.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("Employee") // Changed from "1" to a meaningful value
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Employee extends Person implements Serializable {
    private String codeEmployee;

    @ManyToOne
    @JoinColumn(name = "up_hierarchique_id")
    private Employee upHierarchique;

    @ManyToMany
    @JoinTable(
            name = "employee_group",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id")
    )
    private Set<UserGroupe> groups = new HashSet<>();
}
