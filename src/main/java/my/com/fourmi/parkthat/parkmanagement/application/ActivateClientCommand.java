package my.com.fourmi.parkthat.parkmanagement.application;

public class ActivateClientCommand {

    private String activationCode;

    private String phoneNo;
    
    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public ActivateClientCommand(String activationCode, String phoneNo) {
        super();
        this.activationCode = activationCode;
        this.phoneNo = phoneNo;
    }

}
