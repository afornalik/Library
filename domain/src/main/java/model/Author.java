package model;




import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="author")
@Getter
@Setter
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_author")
    private Long idAuthor;

    @Column(name="first_name",nullable = false)
    private String firstName;

    @Column(name="last_name", nullable = false)
    private String lastName;

    @Column(name="birth_place")
    private String birthPlace;

    @OneToMany
    private List<Book> bookList;
}
