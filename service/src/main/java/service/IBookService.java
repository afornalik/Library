package service;

import dto.BookDto;

import java.util.List;

public interface IBookService {

    List<BookDto> getAllBooks();

    void saveBook(BookDto bookDto);
}
