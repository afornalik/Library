package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="borrow")
@Getter
@Setter
public class Borrow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_borrow")
    private Long idBorrow;

    @OneToMany
    @JoinColumn(name="book_id",referencedColumnName = "id_book")
    private List<Book> bookId;

    @OneToMany
    @JoinColumn(name="borrower_id",referencedColumnName = "id_borrower")
    private List<Borrower> borrowerList;

    @Column(name="rental_date",nullable = false)
    private LocalDate rentalDate;
}
