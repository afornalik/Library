package repository;



import model.BorrowerDetails;
import utils.EntityManagerUtils;

import javax.persistence.EntityManager;


public class BorrowerDetailsRepository implements IBorrowDetailsRespository {


    private final EntityManager entityManager;

    public BorrowerDetailsRepository() {
        entityManager = EntityManagerUtils.getInstance().getEntityManager();
    }




    public BorrowerDetails getBorrowerDetailsById(Long id) {
        return entityManager.find(BorrowerDetails.class,id);
    }

    public void save(BorrowerDetails borrowerDetails) {
        entityManager.getTransaction().begin();
        entityManager.persist(borrowerDetails);
        entityManager.getTransaction().commit();
    }

    public void edit(BorrowerDetails borrowerDetails) {
        entityManager.getTransaction().begin();
        BorrowerDetails newBorrowerDetails = entityManager.find(BorrowerDetails.class, borrowerDetails.getIdBorrowerDetails());
        newBorrowerDetails.setAddress(borrowerDetails.getAddress());
        newBorrowerDetails.setBorrower(borrowerDetails.getBorrower());
        newBorrowerDetails.setEmail(borrowerDetails.getEmail());
        newBorrowerDetails.setPhone(borrowerDetails.getPhone());
        entityManager.getTransaction().commit();
    }

    public void delete(BorrowerDetails borrowerDetails) {
        entityManager.getTransaction().begin();
        entityManager.remove(borrowerDetails);
        entityManager.getTransaction().commit();
    }
}
