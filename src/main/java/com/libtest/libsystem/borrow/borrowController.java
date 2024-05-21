package com.libtest.libsystem.borrow;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/borrow")
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('USER')")
public class borrowController {

private final borrowService _borrowingService;

  @PostMapping("/{bookId}/patron/{patronId}")
  public Borrow borrowBook(@PathVariable Integer bookId, @PathVariable Integer patronId) throws NotFoundException {
      return _borrowingService.borrowBook(bookId, patronId);
  }

}
