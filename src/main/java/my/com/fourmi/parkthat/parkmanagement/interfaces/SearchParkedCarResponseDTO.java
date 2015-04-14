package my.com.fourmi.parkthat.parkmanagement.interfaces;

import java.util.ArrayList;
import java.util.List;

public class SearchParkedCarResponseDTO {

    private List<String> plateNos;

    private boolean isSuccess;

    private String message;

    public SearchParkedCarResponseDTO() {
        super();
    }

    public List<String> getPlateNos() {
        if (this.plateNos == null) {
            this.plateNos = new ArrayList<String>();
        }
        return plateNos;
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

    public Integer getSize() {
        if (this.plateNos != null) {
            return this.plateNos.size();
        } else {
            return 0;
        }
    }
}
