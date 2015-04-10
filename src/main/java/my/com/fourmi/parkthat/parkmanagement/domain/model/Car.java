package my.com.fourmi.parkthat.parkmanagement.domain.model;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Configurable
@javax.persistence.Entity
public class Car extends AbstractPersistable<Long> {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String plateNo;

    private ParkingStatus status;
    
    public Car() {
        
    }

    public Car(String plateNo) {
        this.plateNo = plateNo;
        this.status = ParkingStatus.FREE;
    }

    public void park(CarPark carPark) {
        this.status = ParkingStatus.PARKED;
    }

    public void unpark() {
        this.status = ParkingStatus.FREE;
    }

}
