package mapper;

import dto.AuthorDto;
import model.Author;
import repository.AuthorRepository;
import repository.IAuthorRepository;

public class AuthorMapper implements IMapper<Author, AuthorDto> {

    private final IAuthorRepository authorRepository;
    private static AuthorMapper instance;

    public AuthorMapper(IAuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public static AuthorMapper getInstance(IAuthorRepository authorRepository) {
        if(instance == null) {
            instance = new AuthorMapper(authorRepository);
        }
        return instance;
    }

    public Author mapDtoToEntity(AuthorDto authorDto) {
        model.Author author = authorRepository.getAuthorById(Long.parseLong(authorDto.getId()));
        author.setFirstName(authorDto.getFirstName());
        author.setLastName(authorDto.getLastName());
        return author;
    }

    public AuthorDto mapEntityToDto(Author author) {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(String.valueOf(author.getIdAuthor()));
        authorDto.setFirstName(author.getFirstName());
        authorDto.setLastName(author.getLastName());
        return authorDto;
    }
}
