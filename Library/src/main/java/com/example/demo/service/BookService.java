package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Book;
import com.example.demo.dto.BookRequest;
import com.example.demo.dto.BookResponse;
import com.example.demo.model.Author;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.AuthorRepository;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    // Mapping BookRequest to Book entity
    public Book mapToBook(BookRequest bookRequest) {
        Author author = authorRepository.findById(bookRequest.getAuthorId())
                .orElseThrow(() -> new RuntimeException("Author not found"));

        return Book.builder()
                .title(bookRequest.getTitle())
                .genre(bookRequest.getGenre())
                .availabilityStatus(bookRequest.getAvailabilityStatus())
                .author(author)
                .build();
    }

    // Mapping Book entity to BookResponseDTO
    public BookResponse mapToBookResponse(Book book) {
        return BookResponse.builder()
                .id(book.getId())
                .title(book.getTitle())
                .genre(book.getGenre())
                .availabilityStatus(book.getAvailabilityStatus())
                .authorId(book.getAuthor().getId())
                .build();
    }

    // Create Book
    public BookResponse createBook(BookRequest bookRequest) {
        Book book = mapToBook(bookRequest);
        book = bookRepository.save(book);
        return mapToBookResponse(book);
    }

    // Get Book by Id
    public BookResponse getBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        return mapToBookResponse(book);
    }

    // Update Book by Id
    public BookResponse updateBookById(Long id, BookRequest bookRequest) {
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        existingBook.setTitle(bookRequest.getTitle());
        existingBook.setGenre(bookRequest.getGenre());
        existingBook.setAvailabilityStatus(bookRequest.getAvailabilityStatus());

        // Optionally update author if authorId is provided
        if (bookRequest.getAuthorId() != null) {
            Author author = authorRepository.findById(bookRequest.getAuthorId())
                    .orElseThrow(() -> new RuntimeException("Author not found"));
            existingBook.setAuthor(author);
        }

        Book updatedBook = bookRepository.save(existingBook);
        return mapToBookResponse(updatedBook);
    }

    // Delete Book by Id
    public boolean deleteBookById(Long id) {
        try {
            bookRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Get all books
    public List<BookResponse> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream()
                    .map(this::mapToBookResponse)
                    .collect(Collectors.toList());
    }
}
