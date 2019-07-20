package service;

import model.Borrow;

public interface IBorrowService {

    Borrow findBorrow(Long id);

    void saveBorrow(Borrow borrow);
}
