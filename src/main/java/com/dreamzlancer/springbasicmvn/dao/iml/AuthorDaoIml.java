package com.dreamzlancer.springbasicmvn.dao.iml;

import com.dreamzlancer.springbasicmvn.dao.AuthorDao;
import com.dreamzlancer.springbasicmvn.domain.Author;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Component
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

    @Override
    public Optional<Author> findOne(long authorId) {
        List<Author> results =  jdbcTemplate.query(
                "SELECT id, name, age from authors WHERE id = ? LIMIT 1",
                new AuthorRowMapper(), authorId
        );
        return results.stream().findFirst();
    }

    @Override
    public List<Author> find() {
        return jdbcTemplate.query(
                "SELECT id, name, age from authors",
                new AuthorRowMapper()
        );
    }

    @Override
    public void update(long id, Author author) {
        jdbcTemplate.update(
                "UPDATE authors SET id = ?, name = ?, age = ? WHERE id = ?",
                author.getId(), author.getName(), author.getAge(), id
        );
    }

    @Override
    public void delete(long id) {
        jdbcTemplate.update(
                "DELETE from authors where id = ?",
                id
        );
    }

    public static class AuthorRowMapper implements RowMapper<Author>{

        @Override
        public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Author.builder()
                    .id(rs.getLong("id"))
                    .name(rs.getString("name"))
                    .age(rs.getInt("age"))
                    .build();
        }
    }
}
