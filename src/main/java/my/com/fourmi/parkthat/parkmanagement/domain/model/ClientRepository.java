package my.com.fourmi.parkthat.parkmanagement.domain.model;

public interface ClientRepository {

    public Client findByPhoneNumber(String phoneNo);

    public Client save(Client client);

}
