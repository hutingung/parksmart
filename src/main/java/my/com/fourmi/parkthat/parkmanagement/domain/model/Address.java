package my.com.fourmi.parkthat.parkmanagement.domain.model;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Configurable
@javax.persistence.Entity
public class Address extends AbstractPersistable<Long> {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String town;

    private String state;
}
