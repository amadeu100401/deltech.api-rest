package http.common.responses;

import http.common.requests.validators.holderValidator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestAccountHolder implements holderValidator {
    private String holderName;
    private String holderEmail;
    private String holderDocument;
    private boolean holderType;
}
