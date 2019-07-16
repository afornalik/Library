package repository;

import model.Book;
import utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class BookRepository implements IBookRepository {

    private final EntityManager entityManager;
    private static BookRepository instance = null;

    public BookRepository() {
        entityManager = EntityManagerUtils.getInstance().getEntityManager();
    }

    public static BookRepository getInstance(){
        if(instance == null) {
            instance = new BookRepository();
        }
        return instance;
    }

    public List<Book> getAllBooks() {
        entityManager.getTransaction().begin();
        String query = "SELECT b FROM Book b";
        List<Book> resultList = entityManager.createQuery(query, Book.class).getResultList();
        entityManager.getTransaction().commit();
        return resultList;
    }

    public Book getBookById(Long id) {
        return entityManager.find(Book.class,id);
    }

    public void save(Book book) {
       try {
           entityManager.getTransaction().begin();
            entityManager.persist(book);
            entityManager.getTransaction().commit();
       }catch (Exception e) {
            entityManager.getTransaction().rollback();
       }
    }

    public void edit(Book book) {
        entityManager.getTransaction().begin();
        Book newBook = entityManager.find(Book.class, book.getIdBook());
        newBook.setAuthor(book.getAuthor());
        newBook.setBorrow(book.getBorrow());
        newBook.setBorrows(book.getBorrows());
        newBook.setCategory(book.getCategory());
        newBook.setIsbn(book.getIsbn());
        newBook.setPages(book.getPages());
        newBook.setReleaseDate(book.getReleaseDate());
        newBook.setCategory(book.getCategory());
        newBook.setTitle(book.getTitle());

        entityManager.getTransaction().commit();
    }

    public void delete(Book book) {
        entityManager.getTransaction().begin();
        entityManager.remove(book);
        entityManager.getTransaction().commit();
    }
}
