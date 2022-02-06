package com.libraryApp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.libraryApp.entities.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

//	@Query("SELECT b from Book b join Transaction ON b.id = t.book_id WHERE t.user_id = ?1 AND t.return_date IS NULL;")
//	List<Book> findBookBorrowed();
	
}
