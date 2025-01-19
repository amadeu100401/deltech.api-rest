package application.common.DTOS;

import domain.entities.BankAccount;
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
}
