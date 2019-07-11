package repository;


import model.Borrower;

import java.util.List;

public interface IBorrowerRepository {

    List<Borrower> getAllBorrowers();

    Borrower getBorrowerById(Long id);

    void save(Borrower borrower);

    void edit(Borrower borrower);

    void delete(Borrower borrower);
}
