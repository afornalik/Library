package model;




import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="author")
@Getter
@Setter
@ToString
//@SuppressWarnings("JpaDataSourceORMInspection")
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

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private Set<Book> books;


}
