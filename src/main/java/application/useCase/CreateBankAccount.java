package application.useCase;

import application.common.DTOS.BankAccountDTO;

public interface CreateBankAccount {
    void createBankAccount(BankAccountDTO request);
}
