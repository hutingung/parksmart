package my.com.fourmi.parkthat.parkmanagement.domain.model;

public interface ParkCarTransactionRepository {

    public ParkCarTransaction findById(Long id);
    
    public ParkCarTransaction save(ParkCarTransaction parkCarTransaction);
}
