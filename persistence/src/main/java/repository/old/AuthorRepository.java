package repository.old;

import model.Author;

import javax.persistence.EntityManager;

public class AuthorRepository extends GenericRepository<Author,Long> {

    protected AuthorRepository(EntityManager entityManager) {
        super(entityManager);
    }
}
