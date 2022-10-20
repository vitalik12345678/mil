package com.data.mil.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@Table
@Entity
public class Weight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long value;

    @ManyToOne
    @JoinColumn(name = "user_weight_id", referencedColumnName = "id", nullable = false)
    private User user;

    @Column
    private LocalDate recordDate;
}
