package my.com.fourmi.parkthat.parkmanagement.application;

public class ParkCarCommand {

    private String phoneNo;

    private String token;

    private String plateNo;
    
    

    public ParkCarCommand(String phoneNo, String plateNo,String token) {
        super();
        this.phoneNo = phoneNo;
        this.token = token;
        this.plateNo = plateNo;
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

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }
    
    
}
