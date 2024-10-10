package com.example.springbeautysalon.entity;

import jakarta.persistence.*;
import lombok.*;

@Table
@ToString(exclude = "client")
@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private Role role;
    @Column
    private String login;
    @Column
    private String password;

    @OneToOne(mappedBy = "user")
    @Access(AccessType.PROPERTY)
    private Client client;
}
