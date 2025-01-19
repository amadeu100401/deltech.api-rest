package domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class BankAccount {
    @Id
    private String id;
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
