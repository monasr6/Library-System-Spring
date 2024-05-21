package com.libtest.libsystem.borrow;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('USER')")
public class borrowController {

private final borrowService _borrowingService;

  @PostMapping("/borrow/{bookId}/patron/{patronId}")
  public Borrow borrowBook(@PathVariable Integer bookId, @PathVariable Integer patronId) throws NotFoundException {
      return _borrowingService.borrowBook(bookId, patronId);
  }

  @PutMapping("/return/{bookId}/patron/{patronId}")
public void returnBook(@PathVariable Integer bookId, @PathVariable Integer patronId) throws NotFoundException {
  _borrowingService.returnBook(bookId, patronId);
}

}
