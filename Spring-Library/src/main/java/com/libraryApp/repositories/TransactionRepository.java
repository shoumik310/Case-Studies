package com.libraryApp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libraryApp.entities.Book;
import com.libraryApp.entities.Reader;
import com.libraryApp.entities.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
	
		Boolean existsByReaderAndBookAndReturnDateNull(Reader reader, Book book);

		List<Transaction> findByReaderAndBookAndReturnDateNull(Reader reader, Book book);
}
