package com.data.mil.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum GenderEnum {
    Male("Male"),
    FEMALE("Female");
    private final String gen;

}
