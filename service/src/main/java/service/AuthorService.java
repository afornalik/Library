package service;

import dto.AuthorDto;
import mapper.AuthorMapper;
import model.Author;
import repository.AuthorRepository;
import repository.IAuthorRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class AuthorService implements IAuthorService {

    private final IAuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    private static AuthorService instance;


    private AuthorService(IAuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
        authorMapper = AuthorMapper.getInstance();
    }

    public static AuthorService getInstance(IAuthorRepository authorRepository) {
        if(instance == null) {
            instance = new AuthorService(authorRepository);
        }
        return instance;
    }


    public List<AuthorDto> getAllAuthors() {
        return authorRepository
                .getAllAuthors()
                .stream()
                .map(authorMapper::mapEntityToDto)
                .collect(Collectors.toList());
    }

    public void saveAuthor(AuthorDto authorDto) {

            Author authorEntity = new Author();
            authorEntity = authorMapper.mapDtoToEntity(authorDto);

        try {
            authorRepository.save(authorEntity);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
