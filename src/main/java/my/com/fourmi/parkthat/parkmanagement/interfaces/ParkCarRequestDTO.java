package my.com.fourmi.parkthat.parkmanagement.interfaces;

public class ParkCarRequestDTO {

    private String phoneNo;

    private String token;

    private String plateNo;

    public ParkCarRequestDTO() {
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

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

}
