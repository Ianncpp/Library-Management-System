package com.codethe.library.repository;

import com.codethe.library.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    List<Author> findByFirstNameIgnoreCase(String firstName);
    List<Author> findByLastNameIgnoreCase(String lastName);

}
