package application.consumers;

import application.common.DTOS.BankAccountDTO;
import application.common.DTOS.MessageWrapper;
import application.common.constants.QueueConstants;
import application.services.saveBankAccount.SaveBankAccount;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class AsyncSaveBankAccount {

    private SaveBankAccount saveBankAccount;

    @RabbitListener(queues = QueueConstants.SAVE_BANK_ACCOUNT_IN, concurrency = "2-5")
    public void saveEntity(String message) {
        try {
            log.info("Persistando no banco de dados");

            MessageWrapper<BankAccountDTO> messageWrapper = new ObjectMapper().readValue(message, new TypeReference<>() {});

            var body = messageWrapper.getBody();
            var entity = body.toEntity();

            saveBankAccount.saveBankAccount(entity);
        } catch (Exception e) {
            log.error("Erro ao persistir no banco de dados", e);
        }
    }
}
