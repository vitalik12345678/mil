package com.data.mil.model;


import com.data.mil.enums.AllergicTypeEnum;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "allergic_reaction", schema = "public", catalog = "mil")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class AllergicReaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "name")
    private String name;

    @Column(nullable = false, name = "record_data")
    private LocalDate recordDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "type")
    private AllergicTypeEnum type;
}
