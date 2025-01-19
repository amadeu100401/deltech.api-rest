package http.common.requests.validators;

import http.common.requests.RequestAccountHolder;
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
