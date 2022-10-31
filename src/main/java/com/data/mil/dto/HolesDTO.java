package com.data.mil.dto;

import com.data.mil.enums.AllergicTypeEnum;
import com.data.mil.enums.HolesStatusEnum;
import com.data.mil.model_mapper.Convertable;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class HolesDTO implements Convertable {
    private String place;
    private HolesStatusEnum status;
    private LocalDate recordDate;
}
