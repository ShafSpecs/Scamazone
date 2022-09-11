package com.nigerians.scamazone.dtos.Requests;

import com.nigerians.scamazone.data.models.Roles;

import java.io.Serializable;

/**
 * A DTO for the {@link com.nigerians.scamazone.data.models.Seller} entity
 */
public record RegisterSellerRequest(String firstName, String lastName, String email, String password, String address,
                                    Roles role) implements Serializable {}