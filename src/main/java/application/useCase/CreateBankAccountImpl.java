package application.useCase;

import application.common.DTOs.BankAccountDTO;
import application.common.DTOs.MessageWrapper;
import application.common.constants.QueueConstants;
import application.services.amqpServices.service.AmqpPublisher;
import http.common.responses.CreateBankAccountResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class CreateBankAccountImpl implements CreateBankAccount {

    private AmqpPublisher amqpPublisher;

    @Override
    public Optional<CreateBankAccountResponse> createBankAccount(BankAccountDTO request) {
        try {
            log.info("Enviando para a fila de persistência.");
            var message = new MessageWrapper<>(request);
            amqpPublisher.sendMessage(QueueConstants.SAVE_BANK_ACCOUNT_WAIT, message);
            return Optional.of(request.toResponse());
        } catch (Exception ex) {
            log.error("Erro ao tentar enviar para fila de persistência.");
        }

        return Optional.empty();
    }
}
