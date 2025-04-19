package com.dreamzlancer.springbasicmvn.dao.iml;

import com.dreamzlancer.springbasicmvn.dao.AuthorDao;
import com.dreamzlancer.springbasicmvn.domain.Author;
import org.springframework.jdbc.core.JdbcTemplate;

public class AuthorDaoIml implements AuthorDao {

    private final JdbcTemplate jdbcTemplate;

    public AuthorDaoIml(final JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Author author) {
        jdbcTemplate.update("INSERT INTO authors(id, name, age) VALUES (?, ? , ?)",
                author.getId(), author.getName(), author.getAge());
    }
}
