package com.spring.bookontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.bookservice.BookService;
import com.spring.entity.Book.Book;

@RestController
public class BookController {
	
	@Autowired
    private BookService bookService;
    
    @GetMapping("/getAllBooks")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
    
    @GetMapping("getBookById/{id}")
    public Optional<Book> getBookById(@PathVariable Integer id) {
        
        return bookService.getBookById(id);
    }
    
    @PostMapping("/addBook")
    public void createBook(@RequestBody Book book) {
       
         bookService.createBook(book);
    }
    
    @PutMapping("updateBook/{id}")
    public Book updateBook(@PathVariable Integer id, @RequestBody Book updatedBook) {
       
        return bookService.updateBook(id, updatedBook);
    }
    
    @DeleteMapping("deleteById/{id}")
    public void deleteBook(@PathVariable Integer id) {
        bookService.deleteBook(id);
       System.out.println("Book deleted");
    }

}
