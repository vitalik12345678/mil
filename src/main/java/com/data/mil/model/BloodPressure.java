package com.data.mil.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "blood_pressure",schema = "public")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class BloodPressure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "down_pressure", nullable = false)
    private Long downPressure;

    @Column(name = "upper_pressure", nullable = false)
    private Long upperPressure;

    @Column(name = "record_date", nullable = false)
    private LocalDate recordDate;



}
