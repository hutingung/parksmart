package my.com.fourmi.parkthat.parkmanagement.infrastructure.jpa;

import my.com.fourmi.parkthat.parkmanagement.domain.model.Client;
import my.com.fourmi.parkthat.parkmanagement.domain.model.ClientRepository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepositoryImpl extends JpaRepository<Client, Long>,
        ClientRepository {

}
