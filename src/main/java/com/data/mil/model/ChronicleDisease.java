package com.data.mil.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "cronical_disease", schema = "public")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class ChronicleDisease {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "disease", nullable = false)
    private String disease;

    @Column(name = "record_date", nullable = false)
    private LocalDate recordDate;

}
