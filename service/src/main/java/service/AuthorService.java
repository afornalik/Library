package service;

import model.Author;
import repository.AuthorRepository;

import java.util.List;

public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


}
