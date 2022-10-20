package com.nigerians.scamazone.data.models;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Cart {
    @Id
    private Long id;

    @ElementCollection
    private Set<Item> items = new HashSet<>();
}