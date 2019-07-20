package repository;

import model.Borrow;
import utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class BorrowRepository implements IBorrowRepository {


    private static BorrowRepository instance = null;

    private final EntityManager entityManager;

    private BorrowRepository() {
        entityManager = EntityManagerUtils.getInstance().getEntityManager();
    }

    public static BorrowRepository getInstance() {
        if(instance == null) {
            instance = new BorrowRepository();
        }
        return instance;
    }

    public List<Borrow> getAllBorrows() {
        String query = "SELECT a FROM Borrow a";
        return entityManager.createQuery(query,Borrow.class).getResultList();
    }

    public Borrow getBorrowById(Long id) {
        return entityManager.find(Borrow.class,id);
    }

    public void save(Borrow borrow) {
        entityManager.getTransaction().begin();
        entityManager.persist(borrow);
        entityManager.getTransaction().commit();
    }

    public void edit(Borrow borrow) {
        entityManager.getTransaction().begin();
        Borrow newBorrow = entityManager.find(Borrow.class,borrow.getIdBorrow());
        newBorrow.setBook(borrow.getBook());
        newBorrow.setBorrower(borrow.getBorrower());
        newBorrow.setRentalDate(borrow.getRentalDate());
        entityManager.getTransaction().commit();
    }

    public void delete(Borrow borrow) {
        entityManager.getTransaction().begin();
        entityManager.remove(borrow);
        entityManager.getTransaction().commit();
    }
}
