package com.libraryApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libraryApp.entities.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

}
