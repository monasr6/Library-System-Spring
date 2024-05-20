package com.libtest.libsystem.book;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class bookController {
    
    private final bookService bookService;
  
    public bookController(bookService bookService) {
      this.bookService = bookService;
    }
  
    @GetMapping
    public List<Book> getBooks() {
      return bookService.getBooks();
    }
  
    @GetMapping("/{id}")
    public Book getBook(@PathVariable Integer id) {
      return bookService.getBook(id);
    }
  
    @PostMapping
    public Book createBook(@RequestBody Book book) {
      return bookService.createBook(book);
    }
  
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Integer id, @RequestBody Book book) {
      return bookService.updateBook(id, book);
    }
  
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Integer id) {
      bookService.deleteBook(id);
    }
}
