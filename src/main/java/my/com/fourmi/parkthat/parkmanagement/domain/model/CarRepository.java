package my.com.fourmi.parkthat.parkmanagement.domain.model;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CarRepository {

    public Car findByPlateNo(String plateNo);

    //TODO - Move to Finder instead of repo
    @Query(value = "SELECT * FROM car WHERE plateNo LIKE %:plateNo% and status = 'PARKED'", nativeQuery = true)
    public List<Car> searchParkedCarByPlateNo(@Param("plateNo") String plateNo);

    public Car save(Car car);

}
