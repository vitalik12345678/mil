package com.data.mil.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AllergicTypeEnum {

    PEOPLE ("PEOPLE"),
    PLANTS("PLANTS"),
    DRUG("DRUG"),
    FOOD("FOOD"),
    INSECT("INSECT"),
    PET("PET"),
    LATEX("LATEX"),
    MOLD("MOLD"),
    POLLEN("POLLEN"),
    DUST("DUST");

    private final String type;

}
