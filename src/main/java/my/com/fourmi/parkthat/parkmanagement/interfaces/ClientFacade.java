package my.com.fourmi.parkthat.parkmanagement.interfaces;

public interface ClientFacade {

    public RegisterClientResponseDTO register(RegisterClientRequestDTO request);
    
    public ActivateClientResponseDTO activate(ActivateClientRequestDTO request);
}
