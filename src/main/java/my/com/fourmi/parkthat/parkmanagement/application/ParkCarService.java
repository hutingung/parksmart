package my.com.fourmi.parkthat.parkmanagement.application;

import java.util.List;

import my.com.fourmi.parkthat.parkmanagement.domain.model.Car;
import my.com.fourmi.parkthat.parkmanagement.domain.model.ParkCarTransaction;

public interface ParkCarService {

    public ParkCarTransaction park(ParkCarCommand command);

    public ParkCarTransaction unpark(UnparkCarCommand command);
    
    public List<Car> searchParkedCar(String plateNo);
}
