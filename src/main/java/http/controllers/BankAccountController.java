package http.controllers;

import application.useCase.CreateBankAccount;
import http.common.requests.CreateBankAccountRequest;
import org.springframework.validation.annotation.Validated;
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
    public String createBankAccount(@RequestBody @Validated CreateBankAccountRequest request) {
        var dto = request.toDTO();
        createBankAccount.createBankAccount(dto);
        return "Teste";
    }
}
