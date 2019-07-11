package repository;

import model.Book;
import utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class BookRepository implements IBookRepository {

    private final EntityManager entityManager;

    public BookRepository() {
        entityManager = EntityManagerUtils.getInstance().getEntityManager();
    }


    public List<Book> getAllBooks() {
        String query = "SELECT b FROM Book b";
        return entityManager.createQuery(query,Book.class).getResultList();
    }

    public Book getBookById(Long id) {
        return entityManager.find(Book.class,id);
    }

    public void save(Book book) {
        entityManager.getTransaction().begin();
        entityManager.persist(book);
        entityManager.getTransaction().commit();
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
