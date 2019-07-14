package dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookDto {

    private String id;
    private String category;
    private String borrower;
    private String isbn;
    private String pages;
    private String author;
    private String summary;
    private String title;
    private String releaseDate;
    private List<String> borrowDateList;
    private List<String> borrowerList;

}
