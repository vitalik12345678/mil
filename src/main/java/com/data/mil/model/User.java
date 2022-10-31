package com.data.mil.model;

import com.data.mil.enums.GenderEnum;
import com.data.mil.enums.RankEnum;
import com.data.mil.model_mapper.Convertable;
import com.data.mil.utils.PostgreSQLEnumType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users", schema = "public", catalog = "mil")
@Getter
@Setter
@TypeDef(
        name = "pgsql_enum",
        typeClass = PostgreSQLEnumType.class
)
public class User implements Convertable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Basic
    @Column(name = "first_name")
    private String firstName;

    @Basic
    @Column(name = "last_name")
    private String lastName;

    @Basic
    @Column(name = "email")
    private String email;

    @Basic
    @Column(name = "password")
    private String password;

    @Basic
    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Basic
    @Column(name = "height")
    private Long height;

    @Basic
    @Column(name = "phone_number")
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column (name = "rank")
    @Type( type = "pgsql_enum")
    private RankEnum rank;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    @Type( type = "pgsql_enum")
    private GenderEnum gender;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<AllergicReaction> allergicReactionList;

    //TODO: change CascadeType
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "user_blood_id")
    private List<BloodPressure> bloodPressureList;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "user_hronical_id")
    private List<ChronicleDisease> chronicleDiseaseList;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<ChronicleDisease> cronicalDiseasesById;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Holes> holeList;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "user_pulse_id")
    private List<Pulse> pulseList;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "user_surgical_id")
    private List<Surgery> surgeryList;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "user_temperature_id")
    private List<Temperature> temperatureList;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "user_immunization_id")
    private List<Vaccine> vaccineList;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Weight> weightList;

    @ManyToOne()
    @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
    private Role role;
}
