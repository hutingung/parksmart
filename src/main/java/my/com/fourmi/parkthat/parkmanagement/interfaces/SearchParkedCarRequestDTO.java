package my.com.fourmi.parkthat.parkmanagement.interfaces;

public class SearchParkedCarRequestDTO {

    private String plateNo;

    public SearchParkedCarRequestDTO() {
        super();
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

}
