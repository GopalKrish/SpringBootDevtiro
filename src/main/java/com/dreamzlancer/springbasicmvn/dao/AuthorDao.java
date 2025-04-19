package com.dreamzlancer.springbasicmvn.dao;

import com.dreamzlancer.springbasicmvn.domain.Author;

import java.util.Optional;

public interface AuthorDao {
    void create(Author author);

    Optional<Author> findOne(long i);
}
