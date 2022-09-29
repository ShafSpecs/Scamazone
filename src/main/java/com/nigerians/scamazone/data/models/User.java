package com.nigerians.scamazone.data.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@MappedSuperclass
public class User {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @NotBlank(message = "Firstname is required")
    private String firstName;
    @NotBlank(message = "Lastname is required")
    private String lastName;
    @Column(unique = true)
    @NotBlank(message = "Email is required")
    @Email(message = "Email must be valid")
    private String email;
    @NotBlank(message = "Password is required")
    private String password;
    private String address;

    public User (String firstName, String lastName, String email, String password, String address){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.address = address;
    }

    public User (String firstName, String lastName, String email, String password){
        this(firstName, lastName, email, password, null);
    }

    public User () {
        this(null, null, null, null, null);
    }
}