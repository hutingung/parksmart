package my.com.fourmi.parkthat.parkmanagement.interfaces;

public class ActivateClientResponseDTO {

    private String token;

    public ActivateClientResponseDTO(String token) {
        super();
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
