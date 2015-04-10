package my.com.fourmi.parkthat.parkmanagement.infrastructure.jpa;

import my.com.fourmi.parkthat.parkmanagement.domain.model.CarPark;
import my.com.fourmi.parkthat.parkmanagement.domain.model.CarParkRepository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarParkRepositoryImpl extends JpaRepository<CarPark, Long>,
        CarParkRepository {

}
