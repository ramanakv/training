package com.trg.boot.book.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trg.boot.book.entity.Book;

@Repository
public interface BookRepository  extends JpaRepository<Book, Integer> {

}
