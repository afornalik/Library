import model.Author;
import org.junit.Test;
import repository.AuthorRepository;
import utils.EntityManagerUtils;

import javax.persistence.EntityManager;

public class AuthorRepositoryTest {

    private AuthorRepository authorRepository;
    private EntityManagerUtils entityManagerUtils = EntityManagerUtils.getInstance();

    @Test
    public void ShouldAddNewAuthor() {
        EntityManager entityManager = entityManagerUtils.getEntityManager();

        System.out.println(entityManager.find(Author.class,1l));


    }

    @Test
    public void ShouldAddNew() {
        EntityManager entityManager = entityManagerUtils.getEntityManager();
        Author author = new Author();

        author.setBirthPlace("d");
        author.setFirstName("Adam");
        author.setLastName("Mickiewicz");
        entityManager.getTransaction().begin();
      //  entityManager.persist(author);
        entityManager.getTransaction().commit();
    }
}
