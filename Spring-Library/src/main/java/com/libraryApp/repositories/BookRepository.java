package com.libraryApp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.libraryApp.entities.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

	@Query(value = "SELECT * from Book b join Transaction t ON b.id = t.book_id WHERE t.reader_id = ?1 AND t.return_date IS NULL;", nativeQuery = true)
	List<Book> findBorrowedBooksByReaderID(int readerId);

}
