package http.common.responses;

import http.common.requests.validators.HolderValidator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestAccountHolder implements HolderValidator {
    private String holderName;
    private String holderEmail;
    private String holderDocument;
    private boolean holderType;
}
