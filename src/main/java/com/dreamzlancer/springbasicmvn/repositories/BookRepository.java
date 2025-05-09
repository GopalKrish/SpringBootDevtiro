package com.dreamzlancer.springbasicmvn.repositories;

import com.dreamzlancer.springbasicmvn.domain.entities.BookEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, String> {
}
