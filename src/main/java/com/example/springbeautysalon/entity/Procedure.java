package com.example.springbeautysalon.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Table(name = "TB_procedure")
@ToString(exclude = {"workerSet", "materials"})
@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Procedure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String name;
    @Column
    private double price;

    @OneToMany(mappedBy = "procedure", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Set<Worker> workerSet = new HashSet<>();

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinTable(name = "tb_procedure_material", joinColumns = {
            @JoinColumn(name = "procedure_id")},
            inverseJoinColumns = {@JoinColumn(name = "material_id")
            })
    private Set<Material> materials = new HashSet<>();
}
