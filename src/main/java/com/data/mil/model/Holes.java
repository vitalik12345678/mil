package com.data.mil.model;

import com.data.mil.enums.HolesStatusEnum;
import com.data.mil.model_mapper.Convertable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;

@Table
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Holes implements Convertable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "place", nullable = false)
    private String place;

    @Column(name = "record_date", nullable = false)
    private LocalDate recordDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    @Type( type = "pgsql_enum")
    private HolesStatusEnum status;

    @ManyToOne
    @JoinColumn(name = "user_holes_id", referencedColumnName = "id", nullable = false)
    private User user;

}
