package my.com.fourmi.parkthat.parkmanagement.domain.model;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Configurable
@javax.persistence.Entity
public class Balance extends AbstractPersistable<Long> {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private BigDecimal currentBalance;

    public Balance() {
        this.currentBalance = new BigDecimal("0.00");
    }

    public Balance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }

    public boolean isMinimumBalanceRequired() {
        return currentBalance.compareTo(new BigDecimal("1.00")) > 0;
    }

    public void addParkCarTransaction(ParkCarTransaction charges) {
        this.currentBalance = this.currentBalance
                .subtract(charges.getCharges());
    }

    public void reload(CreditReloadTransaction reload) {
        this.currentBalance = this.currentBalance.add(reload.getAmount());
    }
    
    public BigDecimal getCurrentBalance() {
        return this.currentBalance;
    }
}
