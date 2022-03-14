package com.michael.theBookClub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michael.theBookClub.models.Book;
import com.michael.theBookClub.repositories.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}
	
	public Book showOne(Long id) {
		return bookRepository.findById.orElse(null); 
	}
}
