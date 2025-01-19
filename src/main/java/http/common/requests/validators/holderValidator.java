package http.common.requests.validators;

import jakarta.annotation.Nonnull;

public interface holderValidator {

    @Nonnull
    String getHolderName();

    @Nonnull
    String getHolderEmail();

    @Nonnull
    String getHolderDocument();

    @Nonnull
    boolean isHolderType();
}
