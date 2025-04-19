package com.dreamzlancer.springbasicmvn.dao;

import com.dreamzlancer.springbasicmvn.domain.Book;

import java.util.Optional;

public interface BookDao {
    void create(Book book);

    Optional<Book> find(String s);
}
