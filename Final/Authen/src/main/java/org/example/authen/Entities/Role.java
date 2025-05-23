package org.example.authen.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "role")
public class Role {
    @Id

    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;

    private RoleType role;

    @OneToMany(mappedBy = "role")
    private List<User> users;
}
