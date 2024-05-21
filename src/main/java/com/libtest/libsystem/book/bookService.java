package com.libtest.libsystem.book;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class bookService  {
      
      private final bookRepository _bookRepository;
    
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
        book.setBook_id(id);
        return _bookRepository.save(book);
      }
    
      public void deleteBook(Integer id) {

        Book book = _bookRepository.findById(id).orElse(null);
        if (book == null) {
          return;
        }
        book.setDeleted(1);
        _bookRepository.save(book);

        return;
      }

}