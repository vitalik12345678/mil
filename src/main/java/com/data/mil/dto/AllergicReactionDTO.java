package com.data.mil.dto;

import com.data.mil.enums.AllergicTypeEnum;
import com.data.mil.model_mapper.Convertable;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AllergicReactionDTO implements Convertable {
    private String name;
    private AllergicTypeEnum type;
    private LocalDate recordDate;
}
