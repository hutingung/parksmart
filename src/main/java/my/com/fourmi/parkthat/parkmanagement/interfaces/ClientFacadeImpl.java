package my.com.fourmi.parkthat.parkmanagement.interfaces;

import my.com.fourmi.parkthat.parkmanagement.application.ActivateClientCommand;
import my.com.fourmi.parkthat.parkmanagement.application.ClientService;
import my.com.fourmi.parkthat.parkmanagement.application.RegisterClientCommand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("clientFacadeImpl")
public class ClientFacadeImpl implements ClientFacade {

    private ClientService clientService;

    public RegisterClientResponseDTO register(RegisterClientRequestDTO request) {
        RegisterClientCommand registerClientCommand = new RegisterClientCommand(
                request.getUsername(), request.getPhoneNo(), request.getEmail());
        Long clientId = clientService.registerClient(registerClientCommand);
        RegisterClientResponseDTO response = new RegisterClientResponseDTO(
                clientId, true, "Success");
        return response;
    }

    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    public ActivateClientResponseDTO activate(ActivateClientRequestDTO request) {
        ActivateClientCommand activateClientCommand = new ActivateClientCommand(
                request.getActivationCode(), request.getPhoneNo());
        String token = clientService.activeClient(activateClientCommand);
        ActivateClientResponseDTO response = new ActivateClientResponseDTO(
                token);
        return response;
    }
}
