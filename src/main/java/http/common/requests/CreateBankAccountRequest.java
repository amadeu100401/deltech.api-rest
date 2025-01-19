package http.common.requests;

import application.common.DTOS.AccountHolderDTO;
import application.common.DTOS.BankAccountDTO;
import http.common.responses.RequestAccountHolder;
import http.common.requests.validators.createBankAcountValidator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBankAccountRequest implements createBankAcountValidator {
    private String branch;
    private String number;
    private String type;
    private RequestAccountHolder holder;

    public BankAccountDTO toDTO() {
        return BankAccountDTO.builder()
                .branch(branch)
                .number(number)
                .type(type)
                .holder(buildHolderDTO())
                .build();
    }

    private AccountHolderDTO buildHolderDTO() {
        return AccountHolderDTO.builder()
                .holderDocument(holder.getHolderDocument())
                .holderEmail(holder.getHolderEmail())
                .holderName(holder.getHolderName())
                .holderType(holder.isHolderType())
                .build();
    }
}
