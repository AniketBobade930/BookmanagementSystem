package com.spring.bookservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.Book.Book;
import com.spring.repo.BookRepo;

@Service
public class BookService {

	@Autowired
	private BookRepo bookRepository;

	public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    
    public Optional<Book> getBookById(Integer id) {
        return bookRepository.findById(id);
    }
    
    public void createBook(Book book) {
        bookRepository.save(book);
    }
    
    public Book updateBook(Integer id, Book updatedBook) {
        if (!bookRepository.existsById(id)) {
        	updatedBook.setId(id);
           
        }
        return bookRepository.save(updatedBook);
    }
    
    public void deleteBook(Integer id) {
        bookRepository.deleteById(id);
    }

}
