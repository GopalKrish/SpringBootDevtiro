package com.dreamzlancer.springbasicmvn.mappers.impl;

import com.dreamzlancer.springbasicmvn.domain.dto.BookDto;
import com.dreamzlancer.springbasicmvn.domain.entities.BookEntity;
import com.dreamzlancer.springbasicmvn.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class BookMapper implements Mapper<BookEntity, BookDto> {

    private ModelMapper modelMapper;

    public BookMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public BookDto mapTo(BookEntity book) {
        return modelMapper.map(book, BookDto.class);
    }

    @Override
    public BookEntity mapFrom(BookDto bookDto) {
        return modelMapper.map(bookDto, BookEntity.class);
    }
}
