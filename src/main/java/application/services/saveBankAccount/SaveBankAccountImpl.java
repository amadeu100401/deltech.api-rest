package application.services.saveBankAccount;

import domain.entities.BankAccount;
import infra.repository.BankAccountRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class SaveBankAccountImpl implements SaveBankAccount{

    private BankAccountRepository accountRepository;

    @Override
    public void saveBankAccount(BankAccount entity) {
        try {
            log.info("Persistindo a conta bancária no bando de dados.");
            accountRepository.save(entity);
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
    }
}
