package com.tasty.recipe.service;

import com.tasty.recipe.entity.Author;
import com.tasty.recipe.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }
}
