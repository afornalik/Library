package dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookDto {

    private String id;
    private String isBorrowed;
    private String isbn;
    private String pages;
    private String author;
    private List<String> borrowDateList;
    private List<String> borrowerList;

}
