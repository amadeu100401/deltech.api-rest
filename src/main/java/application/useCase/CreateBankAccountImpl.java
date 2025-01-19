package application.useCase;

import application.common.DTOS.BankAccountDTO;
import application.common.DTOS.MessageWrapper;
import application.common.constants.QueueConstants;
import application.services.amqpServices.service.AmqpPublisher;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class CreateBankAccountImpl implements CreateBankAccount {

    private AmqpPublisher amqpPublisher;

    @Override
    public void createBankAccount(BankAccountDTO request) {
        try {
            log.info("Enviando para a fila de save.");
            var message = new MessageWrapper<>(request);
            amqpPublisher.sendMessage(QueueConstants.SAVE_BANK_ACCOUNT_WAIT, message);
        } catch (Exception ex) {
            log.error("Erro ao tentar enviar para fila de save.");
        }
    }
}
