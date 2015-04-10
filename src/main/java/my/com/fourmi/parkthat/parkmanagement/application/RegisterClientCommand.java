package my.com.fourmi.parkthat.parkmanagement.application;

public class RegisterClientCommand {

    private String username;

    private String phoneNo;

    private String email;

    public RegisterClientCommand(String username, String phoneNo, String email) {
        this.username = username;
        this.phoneNo = phoneNo;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
