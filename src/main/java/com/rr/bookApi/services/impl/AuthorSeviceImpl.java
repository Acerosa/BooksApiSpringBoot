package com.rr.bookApi.services.impl;


import com.rr.bookApi.domain.entities.AuthorEntity;
import com.rr.bookApi.repositories.AuthorRepository;
import com.rr.bookApi.services.AuthorService;
import org.springframework.stereotype.Service;

@Service
public class AuthorSeviceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    public AuthorSeviceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public AuthorEntity createAuthor(AuthorEntity authorEntity) {
        return authorRepository.save(authorEntity);
    }

}
