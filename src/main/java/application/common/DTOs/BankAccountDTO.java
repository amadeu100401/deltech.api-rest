package application.common.DTOs;

import domain.entities.BankAccount;
import http.common.responses.CreateBankAccountResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BankAccountDTO {
    private String branch;
    private String number;
    private String type;
    private AccountHolderDTO holder;

    public BankAccount toEntity() {
        return BankAccount.builder()
                .branch(branch)
                .number(number)
                .type(type)
                .holderName(holder.getHolderName())
                .holderDocument(holder.getHolderDocument())
                .holderEmail(holder.getHolderEmail())
                .holderType(holder.isHolderType())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    public CreateBankAccountResponse toResponse() {
        return CreateBankAccountResponse.builder()
                .type(type)
                .holderName(holder.getHolderName())
                .holderEmail(holder.getHolderEmail())
                .build();
    }
}
