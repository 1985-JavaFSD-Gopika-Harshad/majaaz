package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AuthorRequest;
import com.example.demo.dto.AuthorResponse;
import com.example.demo.model.Author;
import com.example.demo.repository.AuthorRepository;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    // Mapping AuthorRequestDTO to Author entity
    public Author mapToAuthor(AuthorRequest authorRequest) {
        return Author.builder()
                .name(authorRequest.getName())
                .awards(authorRequest.getAwards())
                .nationality(authorRequest.getNationality())
                .build();
    }

    // Mapping Author entity to AuthorResponseDTO
    public AuthorResponse mapToAuthorResponse(Author author) {
        return AuthorResponse.builder()
                .id(author.getId())
                .name(author.getName())
                .awards(author.getAwards())
                .nationality(author.getNationality())
                .bookIds(author.getBooks().stream()
                        .map(book -> book.getId())
                        .collect(Collectors.toList()))
                .build();
    }

    // Create Author
    public AuthorResponse createAuthor(AuthorRequest authorRequest) {
        Author author = mapToAuthor(authorRequest);
        author = authorRepository.save(author);
        return mapToAuthorResponse(author);
    }

    // Get Author by Id
    public AuthorResponse getAuthorById(Long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));
        return mapToAuthorResponse(author);
    }

    // Update Author by Id
    public AuthorResponse updateAuthorById(Long id, AuthorRequest authorRequest) {
        Author existingAuthor = authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));

        existingAuthor.setName(authorRequest.getName());
        existingAuthor.setAwards(authorRequest.getAwards());
        existingAuthor.setNationality(authorRequest.getNationality());

        Author updatedAuthor = authorRepository.save(existingAuthor);
        return mapToAuthorResponse(updatedAuthor);
    }

    // Delete Author by Id
    public boolean deleteAuthorById(Long id) {
        try {
            authorRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Get all authors
    public List<AuthorResponse> getAllAuthors() {
        List<Author> authors = authorRepository.findAll();
        return authors.stream()
                .map(this::mapToAuthorResponse)
                .collect(Collectors.toList());
    }
}
