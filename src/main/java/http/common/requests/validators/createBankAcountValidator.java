package http.common.requests.validators;

import http.common.responses.RequestAccountHolder;
import jakarta.annotation.Nonnull;

public interface createBankAcountValidator {

    @Nonnull
    String getBranch();

    @Nonnull
    String getNumber();

    @Nonnull
    String getType();

    @Nonnull
    RequestAccountHolder getHolder();
}
