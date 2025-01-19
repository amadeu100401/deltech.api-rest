package application.common.exceptions;

import org.springframework.http.HttpStatus;

public class BankAccountException extends RuntimeException {

    public BankAccountException() {
        super("Bank account exception");
    }

    public BankAccountException(String message) {
        super(message);
    }

    public BankAccountException(String message, Throwable cause) {
        super(message, cause);
    }
}
