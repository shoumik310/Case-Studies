package com.libraryApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libraryApp.entities.Reader;
import com.libraryApp.entities.User;
import com.libraryApp.repositories.ReaderRepository;

@Service
public class ReaderManagementService {
	
	@Autowired
	ReaderRepository readerRepo;
	
	public void addReader(Reader reader) {
		readerRepo.save(reader);
	}

	public Reader getReaderByEmail(String readerEmail) {
		return readerRepo.findByEmail(readerEmail);
	}

	public Reader getReaderById(int readerId) {
		return readerRepo.getById(readerId);
	}

	// TODO: implement authUser
//	Boolean authUser();

	public List<Reader> getReaders(){
		return readerRepo.findAll();
	}

//	public void PayFine(int userId) {
//		readerRepo.setFineToZeroById(userId);
//	}
}
