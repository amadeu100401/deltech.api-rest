package domain.entities;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class BankAccount {
    private String branch;
    private String number;
    private String type;
    private String holderName;
    private String holderEmail;
    private String holderDocument;
    private boolean holderType;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
