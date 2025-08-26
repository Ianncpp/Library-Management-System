package com.codethe.library.service;

import com.codethe.library.model.Book;
import com.codethe.library.repository.AuthorRepository;
import com.codethe.library.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public BookService(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.getReferenceById(id);
    }

    @Transactional
    public void saveBook(Book book) {
        if (book.getAuthor() == null) {
            throw new IllegalArgumentException("Book must have an Author");
        }
        bookRepository.save(book);
    }

    @Transactional
    public void deleteBook(Book book) {
        bookRepository.delete(book);
    }

    public List<Book> searchBook(String title) {
        if(title == null || title.trim().isEmpty()) {
            return bookRepository.findAll();
        }
        return bookRepository.findByTitleContainingIgnoreCase(title);
    }
}
