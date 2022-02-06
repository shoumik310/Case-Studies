package com.libraryApp.services;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libraryApp.repositories.BookRepository;
import com.libraryApp.repositories.ReaderRepository;
import com.libraryApp.repositories.TransactionRepository;
import com.libraryApp.entities.Book;
import com.libraryApp.entities.Reader;
import com.libraryApp.entities.Transaction;

@Service
public class TransactionManagementService {
	
	private final int DAILY_FINE_AMOUNT = 10;

	@Autowired
	TransactionRepository transactionRepo;
	
	@Autowired
	ReaderRepository readerRepo;
	
	@Autowired
	BookRepository bookRepo;
	
	@Transactional
	public String addTransaction(Transaction transaction) {
		Reader reader = transaction.getReader();
		Book book = transaction.getBook();
		if(book.getAvailableQuantity()<=0) {
			return "Book Unavailable";
		}else if(reader.getFine()!=0) {
			return "Unpaid Fine";
		}else if(transactionRepo.existsByReaderAndBookAndReturnDateNull(reader, book)) {
			return "Book Already Borrowed";
		}
		transactionRepo.save(transaction);
		reader.setBorrowed(reader.getBorrowed()+1);
		book.setAvailableQuantity(book.getAvailableQuantity()-1);
		readerRepo.save(reader);
		bookRepo.save(book);
		return "";
	}
	
	@Transactional
	public int returnBook(Reader reader, Book book) {
		List<Transaction> transactions = transactionRepo.findByReaderAndBookAndReturnDateNull(reader, book);
		int fine =0;
		if(transactions.size()==0) {
			return -1;
		}
		for(Transaction transaction:transactions) {
			transaction.setReturnDate(LocalDate.now());
			long diff = (ChronoUnit.DAYS.between(transaction.getDueDate(), transaction.getReturnDate()));
			fine+=DAILY_FINE_AMOUNT*(diff>=0?diff:0);
			transactionRepo.save(transaction);
			reader.setBorrowed(reader.getBorrowed()-1);
			book.setAvailableQuantity(book.getAvailableQuantity()+1);
		}
		reader.setFine(fine);
		readerRepo.save(reader);
		bookRepo.save(book);
		return fine;
	}
	
}
