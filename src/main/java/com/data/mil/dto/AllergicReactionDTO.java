package com.data.mil.dto;

import com.data.mil.enums.AllergicTypeEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AllergicReactionDTO {
    private String name;
    private AllergicTypeEnum allergicType;
    private LocalDate date;
}
