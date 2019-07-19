package mapper;

import dto.BookDto;
import model.Book;
import repository.AuthorRepository;
import repository.BookRepository;
import repository.IAuthorRepository;
import repository.IBookRepository;

import java.time.LocalDate;
import java.util.stream.Collectors;

public class BookMapper implements IMapper<Book, BookDto> {

    private static BookMapper instance;
   private final IAuthorRepository authorRepository = AuthorRepository.getInstance();

    private BookMapper( ) {

    }

    public static BookMapper getInstance( ) {
        if(instance == null) {
            instance = new BookMapper ();
        }
        return instance;
    }

    public Book mapDtoToEntity( BookDto bookDto) {
        Book book = new Book();
        if(bookDto.getBorrower().equals("0")) {
            book.setBorrow(false);
        }else {
            book.setBorrow(true);
        }
        book.setCategory(bookDto.getCategory());
        book.setIsbn(bookDto.getIsbn());
        book.setPages(Integer.valueOf(bookDto.getPages()));
        book.setReleaseDate(LocalDate.now());
        book.setSummary(bookDto.getSummary());
        book.setTitle(bookDto.getTitle());
        book.setAuthor(authorRepository.getAuthorById(Long.parseLong(bookDto.getAuthor())));
        return book;
    }

    public BookDto mapEntityToDto( Book book) {
     BookDto bookDto = new BookDto();
        bookDto.setId(String.valueOf(book.getIdBook()));
        bookDto.setCategory(book.getCategory());
        if(book.getBorrow()) {
            bookDto.setBorrower(
                    book.getBorrows()
                            .stream()
                            .map(x -> x.getBorrower().getFirstName()+" "+x.getBorrower().getLastName())
                            .collect(Collectors.joining()));

        }else {
            bookDto.setBorrower(" - ");
        }
        bookDto.setIsbn(book.getIsbn());
        bookDto.setPages(book.getPages().toString());
        bookDto.setReleaseDate(book.getReleaseDate().toString());
        bookDto.setSummary(book.getSummary());
        bookDto.setTitle(book.getTitle());
        bookDto.setAuthor(book.getAuthor().getFirstName()+" "+book.getAuthor().getLastName());
    return bookDto;
    }
}
