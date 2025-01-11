package http.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/deltech")
public class BankAccountController {

    @PostMapping("/bank-account")
    public String createBankAccount() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
