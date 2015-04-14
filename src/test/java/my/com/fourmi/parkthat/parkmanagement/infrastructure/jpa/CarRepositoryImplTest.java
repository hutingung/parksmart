package my.com.fourmi.parkthat.parkmanagement.infrastructure.jpa;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import my.com.fourmi.parkthat.parkmanagement.AbstractParkmanagementIntegrationTest;
import my.com.fourmi.parkthat.parkmanagement.domain.model.Car;
import my.com.fourmi.parkthat.parkmanagement.domain.model.CarRepository;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CarRepositoryImplTest extends
        AbstractParkmanagementIntegrationTest {

    @Autowired
    CarRepository repository;

    @Test
    public void testSearchParkedCarByPlateNo() {
        Car newCar = new Car("WVR2600");
        newCar.park(null);
        this.repository.save(newCar);
        String plateNo = "2600";
        List<Car> car = repository.searchParkedCarByPlateNo(plateNo);
        assertNotNull(car);
    }

}
