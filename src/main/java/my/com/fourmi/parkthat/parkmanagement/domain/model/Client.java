package my.com.fourmi.parkthat.parkmanagement.domain.model;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import my.com.fourmi.parkthat.parkmanagement.domain.service.ClientActivationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Configurable
@javax.persistence.Entity
public class Client extends AbstractPersistable<Long> {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String username;

    private String phoneNumber;

    private String email;

    @OneToOne(optional = true, cascade = CascadeType.ALL)
    private ActivationToken activationToken;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    private Balance balance;

    public Client() {

    }

    public Client(String username, String phoneNumber, String email) {
        this.balance = new Balance(new BigDecimal("1.00"));
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public ActivationToken generateActivationToken() {
        this.activationToken = this.clientActivationService
                .generateActivationToken(this.phoneNumber);
        return this.activationToken;
    }

    // TODO - temporarily to control security
    public boolean isValidToken(String token) {
        return this.activationToken.isValid(token);
    }

    public ParkCarTransaction parkCar(Car car, CarPark carPark) {
        ParkCarTransaction parkCarTransaction = new ParkCarTransaction(this,
                car, carPark);
        return parkCarTransaction;
    }

    public ParkCarTransaction unparkCar(ParkCarTransaction parkCarTransaction) {
        if(parkCarTransaction == null) {
            throw new RuntimeException ("park car transaction not found");
        }
        parkCarTransaction.done(this);
        this.balance.addParkCarTransaction(parkCarTransaction);
        return parkCarTransaction;
    }

    public CreditReloadTransaction reload(BigDecimal amount) {
        CreditReloadTransaction reload = new CreditReloadTransaction(amount);
        this.balance.reload(reload);
        return reload;
    }

    @Transient
    private transient ClientActivationService clientActivationService;

    @Autowired
    public void setClientActivationService(
            ClientActivationService clientActivationService) {
        this.clientActivationService = clientActivationService;
    }

    public ActivationToken activate(String activationCode) {
        this.activationToken = this.clientActivationService.activateToken(
                this.phoneNumber, activationCode);
        return this.activationToken;
    }
    
    public Balance getBalance() {
        return this.balance;
    }
}
