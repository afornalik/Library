package dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BorrowDto {

    private String id;
    private String book;
    private String borrower;
    private String borrowDate;
}
