package com.data.mil.dto;

import com.data.mil.enums.AllergicTypeEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ChronicleDTO {
    private String disease;
    private LocalDate date;
}
