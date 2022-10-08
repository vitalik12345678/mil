package com.data.mil.model;

import com.data.mil.enums.GenderEnum;

import javax.persistence.*;
import java.time.LocalDate;

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_id", nullable = false)
    private Long roleId;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name = "height", nullable = false)
    private Long height;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "gender")
    private GenderEnum gender;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "")
    private Vaccine vaccine;


}
