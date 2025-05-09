package com.dreamzlancer.springbasicmvn.services;

import com.dreamzlancer.springbasicmvn.domain.entities.AuthorEntity;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    AuthorEntity save(AuthorEntity authorEntity);

    List<AuthorEntity> findAll();

    Optional<AuthorEntity> findOne(Long id);

    boolean isExist(long id);

    AuthorEntity partialUpdate(Long id, AuthorEntity authorEntity);

    void delete(Long id);
}
