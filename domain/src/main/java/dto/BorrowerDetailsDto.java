package dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BorrowerDetailsDto {

    private String id;
    private String borrowerAddress;
    private String borrowerEmail;
    private String borrowerPhone;
}
