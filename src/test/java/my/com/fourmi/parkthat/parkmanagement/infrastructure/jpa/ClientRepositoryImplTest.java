package my.com.fourmi.parkthat.parkmanagement.infrastructure.jpa;

import my.com.fourmi.parkthat.parkmanagement.AbstractParkmanagementIntegrationTest;
import my.com.fourmi.parkthat.parkmanagement.domain.model.Client;
import my.com.fourmi.parkthat.parkmanagement.domain.model.ClientRepository;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ClientRepositoryImplTest extends
        AbstractParkmanagementIntegrationTest {

    @Autowired
    ClientRepository repository;
    
    @Test
    public void testFindByPhoneNumber() {
    }

    @Test
    public void testSaveClient() {
        Client client = new Client("hutingung", "0168081440",
                "hutingung@gmail.com");
        repository.save(client);
    }

}
