package com.libtest.libsystem.borrow;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface borrowRepository extends JpaRepository<Borrow, Integer> {
    Optional<Borrow> findByBook_idAndUser_id(Integer book_id, Integer user_id);
}