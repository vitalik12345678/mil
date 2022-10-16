package com.data.mil.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "role",schema = "public")
@Getter
@Setter
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Basic
    @Column(name = "name")
    private String name;

 /*   @OneToMany(mappedBy = "roles",orphanRemoval = true,fetch = FetchType.LAZY)
    private List<User> users;*/
}
