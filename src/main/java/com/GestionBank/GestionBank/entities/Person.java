package com.GestionBank.GestionBank.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_person", discriminatorType = DiscriminatorType.STRING)
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public abstract class Person implements Serializable {
    @Serial
    private static final long serialVersionUID = -8885817712041252438L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(unique = true)
    private String telephone;

    private String firstName;
    private String lastName;
    private String email;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date birthday;

    @Column(name = "person_type", nullable = false)
    private String typePerson;
}
