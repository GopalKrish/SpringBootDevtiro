package com.dreamzlancer.springbasicmvn;

import com.dreamzlancer.springbasicmvn.domain.Book;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class JacksonTest {

    @Test
    public void testThatObjectMapperCanCreateJsonFromJavaObject() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Book book = Book.builder()
                .isbn("978-0-13-478627-1")
                .title("The Engine of Eternity")
                .author("Aria Montgonery")
                .yearPublisher("2005")
                .build();
        String result = objectMapper.writeValueAsString(book);
        assertThat(result).isEqualTo("{\"isbn\":\"978-0-13-478627-1\",\"title\":\"The Engine of Eternity\",\"author\":\"Aria Montgonery\",\"year\":\"2005\"}");

    }

    @Test
    public void testThatObjectMapperCanCreateJavaObjectFromJsonObject() throws JsonProcessingException {
        Book book = Book.builder()
                .isbn("978-0-13-478627-1")
                .title("The Engine of Eternity")
                .author("Aria Montgonery")
                .yearPublisher("2005")
                .build();

        String json = "{\"isbn\":\"978-0-13-478627-1\",\"title\":\"The Engine of Eternity\",\"author\":\"Aria Montgonery\",\"year\":\"2005\"}";
        final ObjectMapper objectMapper = new ObjectMapper();

        Book result = objectMapper.readValue(json, Book.class);
        assertThat(result).isEqualTo(book);
    }
}
