package com.libtest.libsystem.book;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class bookService  {
      
      private final bookRepository _bookRepository;

      @Cacheable("books")
      public List<Book> getBooks() {
        return _bookRepository.findAll();
      }
    
      public Book getBook(Integer id) {
        return _bookRepository.findById(id).orElse(null);
      }
      
      @Transactional
      public Book createBook(Book book) {
        return _bookRepository.save(book);
      }
      
      @Transactional
      public Book updateBook(Integer id, Book book) {
        book.setBook_id(id);
        return _bookRepository.save(book);
      }
    
      @Transactional
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