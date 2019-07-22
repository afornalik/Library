package service;

import dto.BookDto;
import mapper.BookMapper;
import mapper.IMapper;
import model.Book;
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

    @Override
    public BookDto getBook(Long id) {
        return bookMapper.mapEntityToDto(bookRepository.getBookById(id));
    }

    @Override
    public void saveBook(BookDto bookDto) {
        Book bookToSave = bookMapper.mapDtoToEntity(bookDto);
        bookRepository.save(bookToSave);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.delete(bookRepository.getBookById(id));
    }

    @Override
    public void updateBook(BookDto bookDto) {

        Book bookToUpdate = bookMapper.mapDtoToEntity(bookDto);
        bookRepository.edit(bookToUpdate);
    }
}
