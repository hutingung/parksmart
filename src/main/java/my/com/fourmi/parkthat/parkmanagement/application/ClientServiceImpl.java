package my.com.fourmi.parkthat.parkmanagement.application;

import my.com.fourmi.parkthat.parkmanagement.domain.model.ActivationToken;
import my.com.fourmi.parkthat.parkmanagement.domain.model.Client;
import my.com.fourmi.parkthat.parkmanagement.domain.model.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("clientServiceImpl")
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    @Transactional
    public Long registerClient(RegisterClientCommand registerClientCommand) {
        Client client = this.clientRepository
                .findByPhoneNumber(registerClientCommand.getPhoneNo());
        if (client == null) {
            client = new Client(registerClientCommand.getUsername(),
                    registerClientCommand.getPhoneNo(),
                    registerClientCommand.getEmail());
        }
        client.generateActivationToken();
        clientRepository.save(client);
        return client.getId();
    }


    @Transactional
    public String activeClient(ActivateClientCommand activateClientCommand) {
        Client client = this.clientRepository
                .findByPhoneNumber(activateClientCommand.getPhoneNo());
        if (client != null) {
            ActivationToken activationToken = client
                    .activate(activateClientCommand.getActivationCode());
            clientRepository.save(client);
            return activationToken.getToken();
        } else {
            throw new RuntimeException("Not found");
        }
    }

    @Autowired
    public void setClientRepository(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

}
