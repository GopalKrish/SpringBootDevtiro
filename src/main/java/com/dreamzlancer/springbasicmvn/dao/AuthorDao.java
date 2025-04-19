package com.dreamzlancer.springbasicmvn.dao;

import com.dreamzlancer.springbasicmvn.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorDao {
    void create(Author author);

    Optional<Author> findOne(long i);

    List<Author> find();

    void update(long id, Author author);

    void delete(long l);
}
