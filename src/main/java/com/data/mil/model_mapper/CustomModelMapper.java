package com.data.mil.model_mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;

@Component
public class CustomModelMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public CustomModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public <T,D extends Convertable> D convertToEntity(T DTO, D entity){
        return modelMapper.map(DTO,(Type) entity.getClass());
    }

    public <T,D extends Convertable> T convertToDTO(D entity,T DTO){
        return modelMapper.map(entity,(Type) DTO.getClass());
    }

}
