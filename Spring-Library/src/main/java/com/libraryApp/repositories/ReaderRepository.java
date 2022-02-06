package com.libraryApp.repositories;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.libraryApp.entities.Reader;

public interface ReaderRepository extends JpaRepository <Reader, Integer> {
	
	Reader findByEmail(String email);

}
