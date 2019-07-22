package service;

import dto.BookDto;

import java.util.List;

public interface IBookService {

    List<BookDto> getAllBooks();

    BookDto getBook(Long id);

    void saveBook(BookDto bookDto);

    void deleteBook(Long id);

    void updateBook(BookDto bookDto);
}
