package repository;


import model.Book;

import java.util.List;

public interface IBookRepository {

    List<Book> getAllBooks();

    Book getBookById(Long id);

    void save(Book book);

    void edit(Book book);

    void delete(Book book);
}
