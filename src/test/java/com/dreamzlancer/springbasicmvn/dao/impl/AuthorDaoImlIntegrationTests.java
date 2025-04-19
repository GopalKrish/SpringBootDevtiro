package com.dreamzlancer.springbasicmvn.dao.impl;

import com.dreamzlancer.springbasicmvn.TestDataUtil;
import com.dreamzlancer.springbasicmvn.dao.iml.AuthorDaoIml;
import com.dreamzlancer.springbasicmvn.domain.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class AuthorDaoImlIntegrationTests {

    private AuthorDaoIml underTest;

    @Autowired
    public AuthorDaoImlIntegrationTests(AuthorDaoIml underTest){
        this.underTest  = underTest;
    }

    @Test
    public void testThatAuthorCanVeCreatedAndRecalled() {
        Author author = TestDataUtil.createTestAuthor();
        underTest.create(author);
        Optional<Author> result = underTest.findOne(author.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(author);

    }
}
