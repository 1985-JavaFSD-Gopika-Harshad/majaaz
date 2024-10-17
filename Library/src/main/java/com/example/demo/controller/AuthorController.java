package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.AuthorRequest;
import com.example.demo.dto.AuthorResponse;
import com.example.demo.service.AuthorService;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    // Create a new author
    @PostMapping
    public ResponseEntity<AuthorResponse> createAuthor(@RequestBody AuthorRequest authorRequest) {
        AuthorResponse createdAuthor = authorService.createAuthor(authorRequest);
        return new ResponseEntity<>(createdAuthor, HttpStatus.CREATED);
    }

    // Get an author by ID
    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponse> getAuthorById(@PathVariable Long id) {
        AuthorResponse authorResponse = authorService.getAuthorById(id);
        return ResponseEntity.ok(authorResponse);
    }

    // Update an author by ID
    @PutMapping("/{id}")
    public ResponseEntity<AuthorResponse> updateAuthorById(@PathVariable Long id, @RequestBody AuthorRequest authorRequest) {
        AuthorResponse updatedAuthor = authorService.updateAuthorById(id, authorRequest);
        return ResponseEntity.ok(updatedAuthor);
    }

    // Delete an author by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthorById(@PathVariable Long id) {
        boolean isDeleted = authorService.deleteAuthorById(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    // Get all authors
    @GetMapping
    public ResponseEntity<List<AuthorResponse>> getAllAuthors() {
        List<AuthorResponse> allAuthors = authorService.getAllAuthors();
        return ResponseEntity.ok(allAuthors);
    }
}
