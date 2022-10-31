package com.data.mil.model;


import com.data.mil.enums.AllergicTypeEnum;
import com.data.mil.model_mapper.Convertable;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "allergic_reaction", schema = "public", catalog = "mil")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class AllergicReaction implements Convertable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "name")
    private String name;

    @Column(nullable = false, name = "record_data")
    private LocalDate recordDate;

    @ManyToOne
    @JoinColumn(name = "user_allergic_id", referencedColumnName = "id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "type")
    @Type( type = "pgsql_enum")
    private AllergicTypeEnum type;



}
