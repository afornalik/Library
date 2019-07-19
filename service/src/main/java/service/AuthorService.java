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

    private static IAuthorService instance = null;


    private AuthorService() {
        this.authorRepository = AuthorRepository.getInstance();
        authorMapper = AuthorMapper.getInstance();
    }

    public static IAuthorService getInstance( ) {
        if(instance == null) {
            instance = new AuthorService();
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
