package my.com.fourmi.parkthat.parkmanagement.domain.model;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Configurable
@javax.persistence.Entity
public class CreditReloadTransaction extends AbstractPersistable<Long>  {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private BigDecimal amount;

    public CreditReloadTransaction(BigDecimal amount) {
        super();
        this.amount = amount;
    }
    
    public BigDecimal getAmount() {
        return this.amount;
    }
}
