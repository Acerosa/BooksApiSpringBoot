package com.rr.bookApi.controllers;

import com.rr.bookApi.domain.dto.AuthorDTO;
import com.rr.bookApi.services.AuthorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {

    private AuthorService authorService;

    public AuthorController(AuthorService author) {
        this.authorService = author;
    }

    @PostMapping(path = "/authors")
    public AuthorDTO createAuthor(@RequestBody AuthorDTO author){

        return authorService.createAuthor(author);
    }
}
