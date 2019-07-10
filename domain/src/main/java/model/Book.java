package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Entity
@Table(name="book")
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_book")
    private Long idBook;

    private Boolean borrow;


    private String category;

    @Column(nullable = false,length = 13)
    private String isbn;

    @Column(length = 11)
    private Integer pages;


    @Column(name="release_date")
    private LocalDate releaseDate;

    @Column(length=350)
    private String summary;

    @Column(nullable=false, length=255)
    private String title;

    @ManyToOne
    @JoinColumn(name="author_id")
    private Author author;

    @OneToMany(mappedBy = "book")
    private Set<Borrow> borrows;
}
