package com.data.mil.model;

import com.data.mil.enums.GenderEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @OneToMany(
            orphanRemoval = true,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "vaccine")
    private List<Vaccine> vaccine;

    @OneToMany(
            orphanRemoval = true,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "weight")
    private List<Weight> weight;

    @OneToMany(
            orphanRemoval = true,
            cascade = CascadeType.ALL
    )
    private List<Holes> holesList;

    @OneToMany(
            orphanRemoval = true,
            cascade = CascadeType.ALL
    )
    private List<Surgery> surgeryList;

    @OneToMany(
            orphanRemoval = true,
            cascade = CascadeType.ALL
    )
    private List<Temperature> temperatureList;

    @OneToMany(
            orphanRemoval = true,
            cascade = CascadeType.ALL
    )
    private List<Pulse> pulseList;

    @OneToMany(
            orphanRemoval = true,
            cascade = CascadeType.ALL
    )
    private List<ChronicleDisease> chronicleDiseaseList;

    @OneToMany(
            orphanRemoval = true,
            cascade = CascadeType.ALL
    )
    private List<BloodPressure> bloodPressureList;

    @OneToMany(
            orphanRemoval = true,
            cascade = CascadeType.ALL
    )
    private List<AllergicReaction> allergicReactionList;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id",referencedColumnName = "id")
    private Role role;


}
