package com.dreamzlancer.springbasicmvn.services;

import com.dreamzlancer.springbasicmvn.domain.entities.BookEntity;

public interface BookService {

    BookEntity createBook(String isbn, BookEntity book);
}
