package my.com.fourmi.parkthat.parkmanagement.application;

import my.com.fourmi.parkthat.parkmanagement.domain.model.ParkCarTransaction;

public interface ParkCarService {

    public ParkCarTransaction park(ParkCarCommand command);

    public ParkCarTransaction unpark(UnparkCarCommand command);
}
