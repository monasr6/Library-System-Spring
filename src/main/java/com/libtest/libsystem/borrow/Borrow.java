package com.libtest.libsystem.borrow;

import java.time.LocalDateTime;

import com.libtest.libsystem.book.Book;
import com.libtest.libsystem.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "borrow")
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDateTime borrowedAt;

    private LocalDateTime returnedAt;

    public void setBorrowedAt(LocalDateTime now) {
        this.borrowedAt = now;
    }

    public void setReturnedAt(LocalDateTime now) {
        this.returnedAt = now;
    }
}