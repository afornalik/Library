package mapper;

import dto.AuthorDto;
import model.Author;
import repository.AuthorRepository;
import repository.IAuthorRepository;

public class AuthorMapper implements IMapper<Author, AuthorDto> {


    private static AuthorMapper instance;

    public AuthorMapper() {

    }

    public static AuthorMapper getInstance() {
        if(instance == null) {
            instance = new AuthorMapper();
        }
        return instance;
    }

    public Author mapDtoToEntity(AuthorDto authorDto) {
        model.Author author = new Author();
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
