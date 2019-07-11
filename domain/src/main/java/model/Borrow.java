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

    @ManyToOne()
    @JoinColumn(name = "book_id",nullable = false)
    private Book book;

    @ManyToOne()
    @JoinColumn(name = "borrower_id",nullable = false)
    private Borrower borrower;

    @Column(name="rental_date",nullable = false)
    private LocalDate rentalDate;
}
