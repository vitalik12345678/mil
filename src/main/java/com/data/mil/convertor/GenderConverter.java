/*
package com.data.mil.convertor;

import com.data.mil.enums.GenderEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class GenderConverter implements AttributeConverter<GenderEnum, String> {
    @Override
    public String convertToDatabaseColumn(GenderEnum genderEnum) {
        return genderEnum.getGen();
    }

    @Override
    public GenderEnum convertToEntityAttribute(String s) {
        return GenderEnum.valueOf(s);
    }
}
*/
