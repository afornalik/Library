package repository;

import model.Author;
import utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class AuthorRepositoryImpl implements AuthorRepository{

    private final EntityManager entityManager;
    private final EntityManagerUtils entityManagerUtils = EntityManagerUtils.getInstance();

    public AuthorRepositoryImpl() {
       entityManager = entityManagerUtils.getEntityManager();
    }


    public List<Author> getAllAuthors() {
        String query = "SELECT a FROM model.Author a";
        return entityManager.createQuery(query,Author.class).getResultList();
    }

    public Author getAuthorById(Long id) {
        return entityManager.find(Author.class,id);
    }
}
