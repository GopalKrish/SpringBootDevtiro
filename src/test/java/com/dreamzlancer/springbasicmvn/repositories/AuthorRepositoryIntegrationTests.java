package com.dreamzlancer.springbasicmvn.repositories;

import com.dreamzlancer.springbasicmvn.TestDataUtil;
import com.dreamzlancer.springbasicmvn.domain.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class AuthorRepositoryIntegrationTests {

    private AuthorRepository underTest;

    @Autowired
    public AuthorRepositoryIntegrationTests(AuthorRepository underTest){
        this.underTest = underTest;
    }

    @Test
    public void testThatAuthorCanBeCreatedAndRecalled(){
        Author author = TestDataUtil.createTestAuthorA();
        underTest.save(author);
        Optional<Author> result = underTest.findById(author.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(author);

    }

    @Test
    public void testThatMultipleAuthorsCanBeCreatedAndRecalled(){
        Author authorA = TestDataUtil.createTestAuthorA();
        Author authorB = TestDataUtil.createTestAuthorA();
        Author authorC = TestDataUtil.createTestAuthorA();
        underTest.save(authorA);
        underTest.save(authorB);
        underTest.save(authorC);
        Iterable<Author> result = underTest.findAll();
        assertThat(result).hasSize(3).containsExactly(authorA, authorB, authorC);

    }

    @Test
    public void testThatAuthorCanBeUpdated(){
        Author author = TestDataUtil.createTestAuthorA();
        underTest.save(author);
        author.setName("UPDATED");
        underTest.save(author);
        Optional<Author> result = underTest.findById(author.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(author);
    }
}
