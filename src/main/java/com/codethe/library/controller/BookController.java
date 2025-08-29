package com.codethe.library.controller;

import com.codethe.library.model.Book;
import com.codethe.library.service.AuthorService;
import com.codethe.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;

    @Autowired
    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping
    public String getAllBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "book/books";
    }

    @GetMapping("/new")
    public String newBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("authors", authorService.findAllAuthors());
        return "book/books-add";
    }

    @GetMapping("/bnew")
    public String newBookFromAuthor(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("authors", authorService.findAllAuthors());
        return "book/books-auth-add";
    }

    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookService.getBookById(id));
        model.addAttribute("authors", authorService.findAllAuthors());
        return "book/books-edit";
    }

    @PostMapping("/save")
    public String saveBook(@ModelAttribute("book") Book book, Model model) {
        bookService.saveBook(book);
        model.addAttribute("book", book);
        model.addAttribute("authors", authorService.findAllAuthors());
        model.addAttribute("message", "Book saved successfully!");
        return "book/books-edit"; // sau books-add dacă era un nou book
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        Book book = bookService.getBookById(id);
        bookService.deleteBook(book);
        return "redirect:/books";
    }

    @GetMapping("/search")
    public String searchBook(@RequestParam(name = "title", required = false, defaultValue = "") String title, Model model) {
        model.addAttribute("books", bookService.searchBook(title));
        model.addAttribute("title", title);
        return "book/books";
    }
}