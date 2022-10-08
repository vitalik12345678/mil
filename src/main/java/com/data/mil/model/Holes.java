package com.data.mil.model;

import com.data.mil.enums.HolesStatusEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Table
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Holes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "place", nullable = false)
    private String place;

    @Column(name = "record_date", nullable = false)
    private LocalDate recordDate;

    @Column(name = "status", nullable = false)
    private HolesStatusEnum status;

}
