package http.controllers.common.requests;

import http.controllers.common.dtos.AccountHolderDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBankAccountDTO {
    private String branch;
    private String number;
    private String type;
    private AccountHolderDTO holder;
}
