package com.dreamzlancer.springbasicmvn.repositories;

import com.dreamzlancer.springbasicmvn.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, String> {
}
