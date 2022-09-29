package com.nigerians.scamazone.dtos.Requests;

import lombok.*;

import java.io.Serializable;

/**
 * A DTO for the {@link com.nigerians.scamazone.data.models.Store} entity
 */
@Data
@AllArgsConstructor
public class CreateStoreRequest implements Serializable {
    private String userId;
    private String name;
    private String description;
    private String image;
}