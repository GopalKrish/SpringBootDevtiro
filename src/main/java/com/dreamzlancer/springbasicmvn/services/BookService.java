package com.dreamzlancer.springbasicmvn.services;

import com.dreamzlancer.springbasicmvn.domain.entities.BookEntity;

import java.util.List;
import java.util.Optional;

public interface BookService {

    BookEntity createUpdateBook(String isbn, BookEntity book);

    List<BookEntity> findAll();

    Optional<BookEntity> findOne(String isbn);

    boolean isExist(String isbn);
}
