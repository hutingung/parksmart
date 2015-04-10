package my.com.fourmi.parkthat.parkmanagement.interfaces;

public class ParkCarResponseDTO {

    private Long id;

    private boolean isSuccess;

    private String message;

    public ParkCarResponseDTO() {
        super();
    }

    public ParkCarResponseDTO(Long id, boolean isSuccess, String message) {
        super();
        this.id = id;
        this.isSuccess = isSuccess;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
