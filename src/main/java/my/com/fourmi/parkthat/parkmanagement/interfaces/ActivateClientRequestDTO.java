package my.com.fourmi.parkthat.parkmanagement.interfaces;

public class ActivateClientRequestDTO {
    
    private String phoneNo;
    
    private String activationCode;
    
    

    public ActivateClientRequestDTO() {
        super();
    }



    public ActivateClientRequestDTO(String phoneNo, String activationCode) {
        super();
        this.phoneNo = phoneNo;
        this.activationCode = activationCode;
    }



    public String getPhoneNo() {
        return phoneNo;
    }



    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }



    public String getActivationCode() {
        return activationCode;
    }



    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }
    
    

}
