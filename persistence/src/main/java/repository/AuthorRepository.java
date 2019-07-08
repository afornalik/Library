package repository;

import model.Author;

import java.util.List;

public interface AuthorRepository {

    List getAllAuthors();

    Author getAuthorById(Long id);
}
