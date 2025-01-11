package http.controllers.common.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountHolderDTO {
    private String holderName;
    private String holderEmail;
    private String holderDocument;
    private boolean holderType;
}
