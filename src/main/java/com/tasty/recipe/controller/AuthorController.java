package com.tasty.recipe.controller;

import com.tasty.recipe.entity.Author;
import com.tasty.recipe.entity.Category;
import com.tasty.recipe.entity.City;
import com.tasty.recipe.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping("/findAuthor")
    public Author searchAuthor(@RequestParam int id) {
        Optional<Author> authorOptional = authorRepository.findById(id);
        if (authorOptional.isPresent()) {
            return authorOptional.get();
        } else {
            return null;
        }
    }

    @GetMapping("/findByName")
    public List<Author> findByName(@RequestParam String name) {
        List<Author> authorList = authorRepository.findByFirstName(name);
        return authorList;
    }

    @PostMapping(
            value = "/createAuthor", consumes = "application/json", produces = "application/json")
    public Author createAuthor(@RequestBody Author author) {
        return authorRepository.save(author);
    }
}
