package com.data.mil.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum HolesStatusEnum {

    LIGHT("Light"),
    MIDDLE("Middle"),
    HARD("Hard");

    private final String status;

}
