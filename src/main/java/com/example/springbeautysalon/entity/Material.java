package com.example.springbeautysalon.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Table
@Builder
@ToString(exclude = "procedures")
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private double price;

    @ManyToMany(mappedBy = "materials", cascade = CascadeType.PERSIST)
    private Set<Procedure> procedures = new HashSet<>();


}
