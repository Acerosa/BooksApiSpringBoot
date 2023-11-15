package com.rr.bookApi.mappers.impls;

import com.rr.bookApi.domain.dto.AuthorDTO;
import com.rr.bookApi.domain.entities.AuthorEntity;
import com.rr.bookApi.mappers.Mapper;
import lombok.extern.apachecommons.CommonsLog;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapperImpl implements Mapper <AuthorEntity, AuthorDTO> {

    private ModelMapper modelMapper;


    public AuthorMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public AuthorDTO mapTo(AuthorEntity authorEntity) {
        return modelMapper.map(authorEntity, AuthorDTO.class);
    }

    @Override
    public AuthorEntity mapFrom(AuthorDTO authorDTO) {
        return modelMapper.map(authorDTO, AuthorEntity.class);
    }
}
