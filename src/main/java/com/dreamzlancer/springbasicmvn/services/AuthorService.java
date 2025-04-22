package com.dreamzlancer.springbasicmvn.services;

import com.dreamzlancer.springbasicmvn.domain.entities.AuthorEntity;

import java.util.List;

public interface AuthorService {
    AuthorEntity createAuthor(AuthorEntity authorEntity);

    List<AuthorEntity> findAll();
}
