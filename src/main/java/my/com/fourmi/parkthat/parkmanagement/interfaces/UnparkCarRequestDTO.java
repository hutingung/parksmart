package my.com.fourmi.parkthat.parkmanagement.interfaces;

public class UnparkCarRequestDTO {

    private String phoneNo;

    private String token;

    private Long id;

    public UnparkCarRequestDTO() {
        super();
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
