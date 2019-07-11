package repository;

import model.Author;

import java.util.List;

public interface IAuthorRepository {

    List<Author> getAllAuthors();

    Author getAuthorById(Long id);

    void save(Author author);

    void edit(Author author);

    void delete(Author author);
}
