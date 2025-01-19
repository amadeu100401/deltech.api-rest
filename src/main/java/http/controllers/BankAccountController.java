package http.controllers;

import application.useCase.CreateBankAccount;
import http.common.requests.CreateBankAccountRequest;
import http.common.responses.CreateBankAccountResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/deltech")
public class BankAccountController extends ExceptionHolder {

    private CreateBankAccount createBankAccount;

    public BankAccountController(CreateBankAccount createBankAccount) {
        this.createBankAccount = createBankAccount;
    }

    @PostMapping("/bank-account")
    public CreateBankAccountResponse createBankAccount(@RequestBody @Valid CreateBankAccountRequest request) {
        var response = createBankAccount.createBankAccount(request.toDTO());
        return response.orElse(null);
    }
}
