package my.com.fourmi.parkthat.parkmanagement.interfaces;

import java.math.BigDecimal;

public class UnparkCarResponseDTO {

    private Long id;

    private boolean isSuccess;

    private String message;

    private BigDecimal balance;

    private BigDecimal charges;
    
    private Long duration;

    public UnparkCarResponseDTO() {
        super();
    }

    public UnparkCarResponseDTO(Long id, Long duration, boolean isSuccess, String message,
            BigDecimal charges, BigDecimal balance) {
        this.id = id;
        this.duration = duration;
        this.isSuccess = isSuccess;
        this.message = message;
        this.charges = charges;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
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

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getCharges() {
        return charges;
    }

    public void setCharges(BigDecimal charges) {
        this.charges = charges;
    }

}
