package application.common.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountHolderDTO {
    private String holderName;
    private String holderEmail;
    private String holderDocument;
    private boolean holderType;
}
