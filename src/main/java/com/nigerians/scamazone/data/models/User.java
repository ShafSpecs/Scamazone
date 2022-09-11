package com.nigerians.scamazone.data.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;

@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @Setter(value = AccessLevel.PRIVATE)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private String password;
    private String address;
    @Enumerated(EnumType.STRING)
    private Roles role;
}