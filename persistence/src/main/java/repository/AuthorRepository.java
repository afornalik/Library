package repository;

import model.Author;
import utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class AuthorRepository implements IAuthorRepository {

    private final EntityManager entityManager;
    private static AuthorRepository instance = null;

    private AuthorRepository() {
        entityManager = EntityManagerUtils.getInstance().getEntityManager();
    }

    public static AuthorRepository getInstance() {
        if(instance == null) {
            instance = new AuthorRepository();
        }
        return instance;
    }


    public List<Author> getAllAuthors() {
        String query = "SELECT a FROM Author a";
        return entityManager.createQuery(query,Author.class).getResultList();
    }

    public Author getAuthorById(Long id) {
        return entityManager.find(Author.class,id);
    }

    public void save(Author author) {
        entityManager.getTransaction().begin();
        entityManager.persist(author);
        entityManager.getTransaction().commit();
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
        entityManager.getTransaction().begin();
        entityManager.remove(author);
        entityManager.getTransaction().commit();
    }
}
