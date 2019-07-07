package repository;

import model.Author;

import javax.persistence.EntityManager;

public class AuthorRepository extends Repository.GenericRepository<Author,Long> {

    protected AuthorRepository(EntityManager entityManager) {
        super(entityManager);
    }
}
