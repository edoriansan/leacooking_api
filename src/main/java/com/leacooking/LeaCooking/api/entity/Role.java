package com.leacooking.LeaCooking.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_seq_gen")
    @SequenceGenerator(name = "role_seq_gen", sequenceName = "role_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @ManyToMany(mappedBy = "roles")  // Mappé par la relation Many-to-Many dans User
    private Set<User> users;
}
