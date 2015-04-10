package my.com.fourmi.parkthat.parkmanagement.application;


public interface ClientService {

    public Long registerClient(RegisterClientCommand registerClientCommand);

    public String activeClient(ActivateClientCommand activateClientCommand);
}
