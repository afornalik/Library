package utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtils  {

    private static EntityManagerUtils entityManagerUtils = null;
    private final EntityManager entityManager;

    private EntityManagerUtils() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mysql-library");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public static EntityManagerUtils getInstance(){
        if(entityManagerUtils == null) {
            entityManagerUtils = new EntityManagerUtils();
        }
        return entityManagerUtils;
    }


    public  EntityManager getEntityManager() {
        return entityManager;
    }
}
