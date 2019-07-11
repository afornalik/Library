package repository;

import model.Borrower;
import utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class BorrowerRepository  implements  IBorrowerRepository{

    private final EntityManager entityManager;

    public BorrowerRepository() {
        entityManager = EntityManagerUtils.getInstance().getEntityManager();
    }


    public List<Borrower> getAllBorrowers() {
        String query = "SELECT a FROM Borrower a";
        return entityManager.createQuery(query,Borrower.class).getResultList();
    }

    public Borrower getBorrowerById(Long id) {
        return entityManager.find(Borrower.class,id);
    }

    public void save(Borrower borrower) {
        entityManager.getTransaction().begin();
        entityManager.persist(borrower);
        entityManager.getTransaction().commit();
    }

    public void edit(Borrower borrower) {
        entityManager.getTransaction().begin();
        Borrower newBorrower = entityManager.find(Borrower.class,borrower.getIdBorrower());
        newBorrower.setFirstName(borrower.getFirstName());
        newBorrower.setLastName(borrower.getLastName());
        newBorrower.setBorrows(borrower.getBorrows());
        newBorrower.setBorrowerDetails(borrower.getBorrowerDetails());
        entityManager.getTransaction().commit();
    }

    public void delete(Borrower borrower) {
        entityManager.getTransaction().begin();
        entityManager.remove(borrower);
        entityManager.getTransaction().commit();
    }
}
