package com.libtest.libsystem.book;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class bookService  {
      
      private final bookRepository _bookRepository;
    
      public bookService(bookRepository bookRepository) {
        this._bookRepository = bookRepository;
      }
    
      public List<Book> getBooks() {
        return _bookRepository.findAll();
      }
    
      public Book getBook(Integer id) {
        return _bookRepository.findById(id).orElse(null);
      }
    
      public Book createBook(Book book) {
        return _bookRepository.save(book);
      }
    
      public Book updateBook(Integer id, Book book) {
        book.setId(id);
        return _bookRepository.save(book);
      }
    
      public void deleteBook(Integer id) {
        _bookRepository.deleteById(id);
        return;
      }

}