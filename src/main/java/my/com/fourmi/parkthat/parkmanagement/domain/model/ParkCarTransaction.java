package my.com.fourmi.parkthat.parkmanagement.domain.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Configurable
@javax.persistence.Entity
public class ParkCarTransaction extends AbstractPersistable<Long> {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private Client client;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private Car car;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private CarPark carPark;

    private Date startTime;

    private Date endTime;

    private BigDecimal charges;

    public ParkCarTransaction() {

    }

    public ParkCarTransaction(Client client, Car car, CarPark carPark) {
        this.client = client;
        this.car = car;
        this.carPark = carPark;
        this.car.park(carPark);
        startTime = new Date();
    }

    public BigDecimal done(Client client) {
        if (client.getId().equals(this.client.getId())) {
            this.endTime = new Date();
            this.car.unpark();
            this.charges = this.carPark.getTotalCharges(startTime, endTime);
            return this.charges;
        } else {
            throw new RuntimeException("Not the same client");
        }
    }
    
    public Long getDuration() {
        long duration = this.endTime.getTime() - this.startTime.getTime();
        return duration;
    }

    public BigDecimal getCharges() {
        return this.charges;
    }

    public BigDecimal getClientLatestBalance() {
        return this.client.getBalance().getCurrentBalance();
    }
}
