package com.data.mil.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AllergicTypeEnum {

    firstType ("firstType"),
    SECOND_TYPE("secondType");

    private final String type;

}
