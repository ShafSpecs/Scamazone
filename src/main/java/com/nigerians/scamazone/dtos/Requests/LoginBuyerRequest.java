package com.nigerians.scamazone.dtos.Requests;

import com.nigerians.scamazone.data.models.User;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * A DTO for the {@link User} entity
 */
@AllArgsConstructor
@Data
public class LoginBuyerRequest implements Serializable {
    @NotBlank(message = "Email is required")
    @Email(message = "Email must be valid")
    private String email;
    @NotBlank(message = "Password is required")
    private String password;
}