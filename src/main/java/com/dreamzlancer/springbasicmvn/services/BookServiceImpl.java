package com.dreamzlancer.springbasicmvn.services;

import com.dreamzlancer.springbasicmvn.domain.entities.BookEntity;
import com.dreamzlancer.springbasicmvn.repositories.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements  BookService{

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public BookEntity createBook(String isbn, BookEntity book) {
        book.setIsbn(isbn);
        return bookRepository.save(book);
    }
}
