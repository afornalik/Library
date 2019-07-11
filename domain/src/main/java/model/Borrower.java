package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="borrower")
@Getter
@Setter
public class Borrower {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_borrower")
    private Long idBorrower;

    @Column(name="first_name",nullable = false)
    private String firstName;

    @Column(name="last_name",nullable = false)
    private String lastName;

    @OneToMany(mappedBy = "borrower",cascade =  CascadeType.ALL)
    private Set<Borrow> borrows;

    @OneToOne
    @JoinColumn(name="borrower_details_id",referencedColumnName = "id_borrower_details")
    private BorrowerDetails borrowerDetails;
}
