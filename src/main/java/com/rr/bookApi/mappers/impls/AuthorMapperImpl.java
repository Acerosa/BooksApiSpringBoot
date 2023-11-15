package com.rr.bookApi.mappers.impls;

import com.rr.bookApi.domain.dto.AuthorDTO;
import com.rr.bookApi.domain.entities.AuthorEntity;
import com.rr.bookApi.mappers.Mapper;

public class AuthorMapperImpl implements Mapper <AuthorEntity, AuthorDTO> {

    @Override
    public AuthorDTO mapTo(AuthorEntity authorEntity) {
        return null;
    }

    @Override
    public AuthorEntity mapFrom(AuthorDTO a) {
        return null;
    }
}
