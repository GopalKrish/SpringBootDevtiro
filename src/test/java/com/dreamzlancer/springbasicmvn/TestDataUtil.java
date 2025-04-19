package com.dreamzlancer.springbasicmvn;

import com.dreamzlancer.springbasicmvn.domain.Author;
import com.dreamzlancer.springbasicmvn.domain.Book;

public final class TestDataUtil {

    private TestDataUtil(){

    }

    public static Author createTestAuthorA() {
        return Author.builder()
                .id(1L)
                .name("Jhon")
                .age(80)
                .build();
    }

    public static Author createTestAuthorB() {
        return Author.builder()
                .id(2L)
                .name("Peter")
                .age(60)
                .build();
    }

    public static Author createTestAuthorC() {
        return Author.builder()
                .id(3L)
                .name("Mark")
                .age(70)
                .build();
    }

    public static Book createTestBookA() {
        return Book.builder()
                .isbn("978-1-2345-6789-1")
                .title("The Shadow in the Attic")
                .authorId(1L)
                .build();
    }

    public static Book createTestBookB() {
        return Book.builder()
                .isbn("978-1-2345-6789-2")
                .title("The Wicked")
                .authorId(1L)
                .build();
    }

    public static Book createTestBookC() {
        return Book.builder()
                .isbn("978-1-2345-6789-3")
                .title("Beyond the Limit")
                .authorId(1L)
                .build();
    }
}
