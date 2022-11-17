package com.api.biblioteca.mapper;

import com.api.biblioteca.dto.LivrosDto;
import com.api.biblioteca.entity.LivrosEntity;
import lombok.experimental.UtilityClass;
import org.modelmapper.ModelMapper;

import java.util.function.Supplier;

@UtilityClass
public class LivrosMapper {

    private final Supplier<ModelMapper> modelMapperSupplier = ModelMapper:: new;

    public LivrosDto livrosToDto(LivrosEntity entity){
        return modelMapperSupplier.get().map(entity, LivrosDto.class);


    }

    public LivrosEntity DtoToLivros(LivrosDto livrosDto){
        return modelMapperSupplier.get().map(livrosDto, LivrosEntity.class);

    }
}
