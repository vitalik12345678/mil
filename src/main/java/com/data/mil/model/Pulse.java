package com.data.mil.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@Table(name = "pulse")
public class Pulse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "value")
    private  Long value;

    @Column(name = "record_date")
    private LocalDate recordDate;

    @Column(name = "user_pulse_id")
    private Integer userPulseId;
}
