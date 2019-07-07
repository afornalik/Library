package model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="borrower_details")
@Getter
@Setter
public class BorrowerDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_borrower_details")
    private Long idBorrowerDetails;

    private String address;

    private String email;

    private String phone;
}
