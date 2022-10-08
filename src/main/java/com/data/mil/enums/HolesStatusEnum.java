package com.data.mil.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum HolesStatusEnum {

    LIGHT("light"),
    MIDDLE("middle"),
    HARD("hard");

    private final String status;

}
