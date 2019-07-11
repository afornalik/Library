package repository;

import model.Author;
import utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class AuthorRepository implements IAuthorRepository {

    private final EntityManager entityManager;
    private final EntityManagerUtils entityManagerUtils = EntityManagerUtils.getInstance();

    public AuthorRepository() {
       entityManager = entityManagerUtils.getEntityManager();
    }


    public List<Author> getAllAuthors() {
        String query = "SELECT a FROM Author a";
        return entityManager.createQuery(query,Author.class).getResultList();
    }

    public Author getAuthorById(Long id) {
        return entityManager.find(Author.class,id);
    }

    public void save(Author author) {
        entityManager.persist(author);
    }

    public void edit(Author author) {
        entityManager.getTransaction().begin();
        Author newAuthor = entityManager.find(Author.class,author.getIdAuthor());
        newAuthor.setFirstName(author.getFirstName());
        newAuthor.setLastName(author.getLastName());
        newAuthor.setBirthPlace(author.getBirthPlace());
        newAuthor.setBooks(author.getBooks());
        entityManager.getTransaction().commit();
    }

    public void delete(Author author) {
        entityManager.remove(author);
    }
}
