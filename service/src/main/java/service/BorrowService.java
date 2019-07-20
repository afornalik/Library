package service;

import model.Borrow;
import repository.BorrowRepository;
import repository.IBorrowRepository;

public class BorrowService implements IBorrowService {

    private final IBorrowRepository borrowRepository;
    private static BorrowService instance = null;

    private BorrowService() {
        borrowRepository = BorrowRepository.getInstance();
    }

    @Override
    public Borrow findBorrow(Long id) {
        return borrowRepository.getBorrowById(id);
    }

    @Override
    public void saveBorrow(Borrow borrow) {
        borrowRepository.save(borrow);
    }
}
