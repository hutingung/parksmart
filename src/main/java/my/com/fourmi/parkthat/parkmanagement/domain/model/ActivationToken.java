package my.com.fourmi.parkthat.parkmanagement.domain.model;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Configurable
@javax.persistence.Entity
public class ActivationToken extends AbstractPersistable<Long> {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String activationCode;

    private String phoneNo;

    private ActivationStatus status;

    private String token;
    
    public ActivationToken() {
        
    }

    public ActivationToken(String phoneNo) {
        this.phoneNo = phoneNo;
        this.generateActivationCode();
    }

    public boolean isValid(String token) {
        return this.token.equals(token)
                && status.equals(ActivationStatus.ACTIVE);
    }

    public String activate(String activationCode) {
        if (activationCode.equals(this.activationCode)) {
            this.status = ActivationStatus.ACTIVE;
            UUID uuid = UUID.randomUUID();
            this.token = uuid.toString();
            return this.token;
        } else {
            throw new RuntimeException("");
        }
    }

    public void regenerateActivationCode() {
        this.generateActivationCode();
        this.token = null;
    }

    public String getToken() {
        return this.token;
    }
    
    public String getPhoneNo() {
        return this.phoneNo;
    }

    private void generateActivationCode() {
        // generate a 4 digit integer 1000 <10000
        int randomPIN = (int) (Math.random() * 9000) + 1000;
        this.activationCode = String.valueOf(randomPIN);
    }
    
    public String getActivationCode() {
        return this.activationCode;
    }

    @Override
    public String toString() {
        return "ActivationToken [activationCode=" + activationCode
                + ", phoneNo=" + phoneNo + ", status=" + status + ", token="
                + token + "]";
    }

}
