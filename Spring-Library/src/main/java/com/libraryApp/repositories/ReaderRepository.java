package com.libraryApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.libraryApp.entities.Reader;

public interface ReaderRepository extends JpaRepository<Reader, Integer> {

	Reader findByEmail(String email);

	@Modifying
	@Query(value = "UPDATE User u SET u.fine = 0 WHERE u.id = ?1", nativeQuery = true)
	int setFineToZeroFor(int userId);
}
