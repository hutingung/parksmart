package my.com.fourmi.parkthat.parkmanagement.domain.model;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Configurable
@javax.persistence.Entity
public class Rate extends AbstractPersistable<Long> {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Long chargingBlock;

    private BigDecimal pricePerBlock;

    public Rate() {

    }

    public Rate(Long chargingBlock, BigDecimal pricePerBlock) {
        this.pricePerBlock = pricePerBlock;
        this.chargingBlock = chargingBlock;
    }

    public BigDecimal getCharges(Date startTime, Date endTime) {
        long difference = endTime.getTime() - startTime.getTime();
        if (difference > chargingBlock) {
            return pricePerBlock.multiply(new BigDecimal(difference
                    / chargingBlock));
        } else {
            return pricePerBlock;
        }
    }

}
