package service;

import dto.AuthorDto;
import mapper.AuthorMapper;
import repository.AuthorRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class AuthorService implements IAuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    private static AuthorService instance;


    private AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
        authorMapper = AuthorMapper.getInstance(authorRepository);
    }

    public AuthorService getInstance(AuthorRepository authorRepository) {
        if(instance == null) {
            instance = new AuthorService(authorRepository);
        }
        return instance;
    }


    public List<AuthorDto> getAllAuthors() {
        List<AuthorDto> authorList =
                authorRepository
                        .getAllAuthors()
                        .stream()
                        .map(authorMapper::mapEntityToDto)
                        .collect(Collectors.toList());
        return authorList;
    }
}
