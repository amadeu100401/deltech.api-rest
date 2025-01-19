package http.common.requests.validators;


import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotBlank;

public interface HolderValidator {

    @NotBlank
    String getHolderName();

    @Nonnull
    String getHolderEmail();

    @Nonnull
    String getHolderDocument();

    @Nonnull
    boolean isHolderType();
}
