package com.codethe.library;

import com.codethe.library.model.Author;
import com.codethe.library.model.Book;
import com.codethe.library.repository.AuthorRepository;
import com.codethe.library.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EntityScan("com.codethe.library.model")
public class LibraryManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryManagementSystemApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(AuthorRepository authorRepo, BookRepository bookRepo) {
        return _ -> {
            System.out.println("""



                    Welcome to Library Management System!


                    """);

            // ==== George Orwell ====
            Author orwell = new Author("George", "Orwell");
            authorRepo.save(orwell);

            bookRepo.save(new Book("1984", "111-AAA", orwell));
            bookRepo.save(new Book("Animal Farm", "111-BBB", orwell));

// ==== John Smith ====
            Author smith = new Author("John", "Smith");
            authorRepo.save(smith);

            bookRepo.save(new Book("Modern Programming", "222-AAA", smith));
            bookRepo.save(new Book("Clean Code Explained", "222-BBB", smith));

// ==== Jane Doe ====
            Author doe = new Author("Jane", "Doe");
            authorRepo.save(doe);

            bookRepo.save(new Book("Introduction to Databases", "333-AAA", doe));
            bookRepo.save(new Book("Advanced SQL Queries", "333-BBB", doe));

// ==== Lucian Cristescu ====
            Author cristescu = new Author("Lucian", "Cristescu");
            authorRepo.save(cristescu);

            bookRepo.save(new Book("Speranța pentru tine", "444-AAA", cristescu));
            bookRepo.save(new Book("Puterea rugăciunii", "444-BBB", cristescu));

// ==== Biblia (Colectiv) ====
            Author biblic = new Author("Colectiv", "Biblic");
            authorRepo.save(biblic);

            bookRepo.save(new Book("Biblia", "555-AAA", biblic));
            bookRepo.save(new Book("Noul Testament", "555-BBB", biblic));

// ==== J.K. Rowling ====
            Author rowling = new Author("J.K.", "Rowling");
            authorRepo.save(rowling);

            bookRepo.save(new Book("Harry Potter and the Philosopher's Stone", "666-AAA", rowling));
            bookRepo.save(new Book("Harry Potter and the Chamber of Secrets", "666-BBB", rowling));

// ==== Leo Tolstoy ====
            Author tolstoy = new Author("Leo", "Tolstoy");
            authorRepo.save(tolstoy);

            bookRepo.save(new Book("War and Peace", "777-AAA", tolstoy));
            bookRepo.save(new Book("Anna Karenina", "777-BBB", tolstoy));

// ==== Fyodor Dostoevsky ====
            Author dostoevsky = new Author("Fyodor", "Dostoevsky");
            authorRepo.save(dostoevsky);

            bookRepo.save(new Book("Crime and Punishment", "888-AAA", dostoevsky));
            bookRepo.save(new Book("The Brothers Karamazov", "888-BBB", dostoevsky));

// ==== Mihai Eminescu ====
            Author eminescu = new Author("Mihai", "Eminescu");
            authorRepo.save(eminescu);

            bookRepo.save(new Book("Luceafărul", "999-AAA", eminescu));
            bookRepo.save(new Book("Poezii", "999-BBB", eminescu));

        };
    }

}
