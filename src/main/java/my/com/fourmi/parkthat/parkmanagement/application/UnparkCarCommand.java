package my.com.fourmi.parkthat.parkmanagement.application;

public class UnparkCarCommand {

    private String phoneNo;

    private String token;

    private Long id;

    public UnparkCarCommand(String phoneNo, Long id, String token) {
        this.phoneNo = phoneNo;
        this.token = token;
        this.id = id;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
