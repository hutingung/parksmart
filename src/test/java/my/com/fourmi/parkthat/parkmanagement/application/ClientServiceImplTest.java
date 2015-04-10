package my.com.fourmi.parkthat.parkmanagement.application;

import my.com.fourmi.parkthat.parkmanagement.AbstractParkmanagementIntegrationTest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ClientServiceImplTest extends
        AbstractParkmanagementIntegrationTest {

    @Autowired
    ClientService clientService;

    @Test
    public void test() {
        RegisterClientCommand registerClientCommand = new RegisterClientCommand(
                "hutingung", "0168081440", "hutingung@gmail.com.my");
        clientService.registerClient(registerClientCommand);

        ActivateClientCommand activateClientCommand = new ActivateClientCommand(
                "1234", "0168081440");
        try {
            clientService.activeClient(activateClientCommand);
        } catch (RuntimeException e) {
        }
    }

}
