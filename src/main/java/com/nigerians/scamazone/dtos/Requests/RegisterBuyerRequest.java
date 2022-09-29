package com.nigerians.scamazone.dtos.Requests;

import com.nigerians.scamazone.data.models.Buyer;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link Buyer} entity
 */
@Data
public class RegisterBuyerRequest implements Serializable {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String address;

    public RegisterBuyerRequest(String firstName, String lastName, String email, String password, String address){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.address = address;
    }
}