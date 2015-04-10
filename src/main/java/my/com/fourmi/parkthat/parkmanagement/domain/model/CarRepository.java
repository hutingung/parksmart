package my.com.fourmi.parkthat.parkmanagement.domain.model;

public interface CarRepository {
    
    public Car findByPlateNo(String plateNo);
    
    public Car save(Car car);

}
