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
    CommandLineRunner commandLineRunner(AuthorRepository authorRepository, BookRepository bookRepository) {
        return args -> {
            System.out.println("""



                    Welcome to Library Management System!


                    """);

            Author a1 = new Author("George", "Orwell");
            authorRepository.save(a1);

            Author a2 = new Author("John", "Doe");
            authorRepository.save(a2);

            Author a3 = new Author("Brad", "Meltzer");
            authorRepository.save(a3);

            Book b1 = new Book("The Dark Knight", "001", a1);
            bookRepository.save(b1);

            Book b2 = new Book("1984", "002", a2);
            bookRepository.save(b2);

            Book b3 = new Book("Harry Potter", "003", a3);
            bookRepository.save(b3);

        };
    }

}
