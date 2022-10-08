package com.data.mil.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AllergicTypeEnum {

    FIRST_TYPE ("first_type"),
    SECOND_TYPE("second_type");

    private final String type;

}
