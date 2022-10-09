package com.data.mil.dto;

import com.data.mil.enums.AllergicTypeEnum;
import com.data.mil.enums.HolesStatusEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class HolesDTO {
    private HolesStatusEnum holesStatusEnum;
    private LocalDate localDate;
}
