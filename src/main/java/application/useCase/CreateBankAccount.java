package application.useCase;

import application.common.DTOs.BankAccountDTO;
import http.common.responses.CreateBankAccountResponse;

import java.util.Optional;

public interface CreateBankAccount {
    Optional<CreateBankAccountResponse> createBankAccount(BankAccountDTO request);
}
