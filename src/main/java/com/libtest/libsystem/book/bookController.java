package com.libtest.libsystem.book;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('USER')")
public class bookController {

  private final bookService _bookService;

  @GetMapping
  public List<Book> getBooks() {
    return _bookService.getBooks();
  }

  @GetMapping("/{id}")
  public Book getBook(@PathVariable Integer id) {
    return _bookService.getBook(id);
  }

  @PostMapping
  public Book createBook(@RequestBody Book book) {
    return _bookService.createBook(book);
  }

  @PutMapping("/{id}")
  public Book updateBook(@PathVariable Integer id, @RequestBody Book book) {
    return _bookService.updateBook(id, book);
  }

  @DeleteMapping("/{id}")
  public void deleteBook(@PathVariable Integer id) {
    _bookService.deleteBook(id);
  }
}
