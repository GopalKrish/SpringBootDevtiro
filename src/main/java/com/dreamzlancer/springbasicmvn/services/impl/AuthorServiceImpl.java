package com.dreamzlancer.springbasicmvn.services.impl;

import com.dreamzlancer.springbasicmvn.domain.entities.AuthorEntity;
import com.dreamzlancer.springbasicmvn.repositories.AuthorRepository;
import com.dreamzlancer.springbasicmvn.services.AuthorService;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public AuthorEntity createAuthor(AuthorEntity authorEntity) {
        return  authorRepository.save(authorEntity);
    }
}
