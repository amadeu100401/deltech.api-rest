package domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Balances {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String bankAccountId;
    private BigDecimal amount;
    private String amountBlocked;
}
