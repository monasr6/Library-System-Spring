package com.libtest.libsystem.borrow;

import java.time.LocalDateTime;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.libtest.libsystem.book.Book;
import com.libtest.libsystem.book.bookRepository;
import com.libtest.libsystem.user.User;
import com.libtest.libsystem.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class borrowService {
    private final borrowRepository _borrowRepository;
    private final bookRepository _bookRepository;
    private final UserRepository _userRepository;

    // constructor...

    public Borrow borrowBook(Integer bookId, Integer userId) throws NotFoundException {
        Book book = _bookRepository.findById(bookId).orElseThrow(() -> new NotFoundException());
        User user = _userRepository.findById(userId).orElseThrow(() -> new NotFoundException());

        Borrow borrowing = new Borrow();
        borrowing.setBook(book);
        borrowing.setUser(user);
        borrowing.setBorrowedAt(LocalDateTime.now());

        return _borrowRepository.save(borrowing);
    }
}