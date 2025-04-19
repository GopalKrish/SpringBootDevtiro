package com.dreamzlancer.springbasicmvn.dao.impl;

import com.dreamzlancer.springbasicmvn.TestDataUtil;
import com.dreamzlancer.springbasicmvn.dao.iml.AuthorDaoIml;
import com.dreamzlancer.springbasicmvn.domain.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

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
        Author author = TestDataUtil.createTestAuthorA();

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

    @Test
    public void testThatFindManyGenerateCorrectSql(){
        underTest.find();
        verify(jdbcTemplate).query(
                eq("SELECT id, name, age from authors"),
                ArgumentMatchers.<AuthorDaoIml.AuthorRowMapper>any()
        );
    }

    @Test void testThatUpdateGeneratesCorrectSql(){
        Author author = TestDataUtil.createTestAuthorA();

        underTest.update(3L, author);

        verify(jdbcTemplate).update(
                "UPDATE authors SET id = ?, name = ?, age = ? WHERE id = ?",
                1L, "Jhon", 80, 3L
        );
    }

    @Test
    public void testThatDeleteGeneratesCorrectSql(){
        underTest.delete(1L);
        verify(jdbcTemplate).update(
                "DELETE from authors where id = ?",
                1L
        );
    }
}
