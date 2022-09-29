package com.nigerians.scamazone.data.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
public class Store {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private String image;

    @OneToMany(mappedBy = "store")
    private Set<Product> product = new HashSet<>();

    public Store(String name, String desc, String img) {
        this.name = name;
        this.description = desc;
        this.image = img;
    }
}