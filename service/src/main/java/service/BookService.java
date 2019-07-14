package service;

import dto.BookDto;
import mapper.BookMapper;
import mapper.IMapper;
import repository.BookRepository;
import repository.IBookRepository;

import java.util.List;
import java.util.stream.Collectors;

public class BookService implements IBookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    private static BookService instance = null;

    private BookService() {
        bookRepository = BookRepository.getInstance();
        bookMapper = BookMapper.getInstance();
    }

    public static BookService getInstance(){
        if(instance==null){
            instance= new BookService();
        }
        return instance;
    }

    @Override
    public List<BookDto> getAllBooks() {
        return bookRepository
                .getAllBooks()
                .stream()
                .map(bookMapper::mapEntityToDto)
                .collect(Collectors.toList());
    }
}
