package com.rr.bookApi.controllers;

import com.rr.bookApi.domain.dto.AuthorDTO;
import com.rr.bookApi.domain.entities.AuthorEntity;
import com.rr.bookApi.mappers.Mapper;
import com.rr.bookApi.services.AuthorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {

    private AuthorService authorService;
    private Mapper<AuthorEntity, AuthorDTO> authorMapper;

    public AuthorController(AuthorService authorService, Mapper<AuthorEntity, AuthorDTO> authorMapper) {
        this.authorService = authorService;
        this.authorMapper = authorMapper;

    }

    @PostMapping(path = "/authors")
    public AuthorDTO createAuthor(@RequestBody AuthorDTO author){
        AuthorEntity authorEntity = authorMapper.mapFrom(author);
        AuthorEntity savedAuthorEntity = authorService.createAuthor(authorEntity);
        return authorMapper.mapTo(savedAuthorEntity);
    }
}
