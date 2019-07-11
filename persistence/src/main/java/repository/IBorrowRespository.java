package repository;


import model.BorrowerDetails;



public interface IBorrowRespository  {

   BorrowerDetails getBorrowerDetailsById(Long id);

    void save(BorrowerDetails borrowerDetails);

    void edit(BorrowerDetails borrowerDetails);

    void delete(BorrowerDetails borrowerDetails);
}
