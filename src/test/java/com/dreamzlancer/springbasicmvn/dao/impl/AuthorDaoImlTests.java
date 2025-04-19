package com.dreamzlancer.springbasicmvn.dao.impl;

import com.dreamzlancer.springbasicmvn.dao.iml.AuthorDaoIml;
import com.dreamzlancer.springbasicmvn.domain.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AuthorDaoImlTests {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private AuthorDaoIml underTest;

    @Test
    public void testThatCreateAuthorGeneratesCorrectSql(){
        Author author = Author.builder()
                .id(1L)
                .name("Jhon")
                .age(80)
                .build();

        underTest.create(author);
        verify(jdbcTemplate).update(
                eq("INSERT INTO authors(id, name, age) VALUES (?, ? , ?)"),
                eq(1L), eq("Jhon"), eq(80)
        );
    }

    @Test
    public void testThatFindOneGeneratesTheCorrectSql(){
        underTest.findOne(1L);
        verify(jdbcTemplate).query(
                eq("SELECT id, name, age from authors WHERE id = ? LIMIT 1"),
                ArgumentMatchers.<AuthorDaoIml.AuthorRowMapper>any(),
                eq(1L)
        );
    }
}
