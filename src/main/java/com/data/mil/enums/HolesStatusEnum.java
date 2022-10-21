package com.data.mil.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum HolesStatusEnum {

    LIGHT("LIGHT"),
    MIDDLE("MIDDLE"),
    HARD("HARD");

    private final String status;

}
