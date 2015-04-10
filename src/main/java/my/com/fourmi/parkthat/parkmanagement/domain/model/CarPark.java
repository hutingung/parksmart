package my.com.fourmi.parkthat.parkmanagement.domain.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Configurable
@javax.persistence.Entity
public class CarPark extends AbstractPersistable<Long> {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String code;

    private String name;

    private String description;

    @OneToOne(optional = true, cascade = CascadeType.ALL)
    private Address address;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    private Rate rate;

    public CarPark() {

    }

    public CarPark(String code, String name, String description, Rate rate) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.rate = rate;
    }

    public BigDecimal getTotalCharges(Date startTime, Date endTime) {
        return this.rate.getCharges(startTime, endTime);
    }

}
