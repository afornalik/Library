package repository;


import model.Borrow;

import java.util.List;

public interface IBorrowRepository {

    List<Borrow> getAllBorrows();

    Borrow getBorrowById(Long id);

    void save(Borrow borrow);

    void edit(Borrow borrow);

    void delete(Borrow borrow);
}
