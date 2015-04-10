package my.com.fourmi.parkthat.parkmanagement.infrastructure.jpa;

import my.com.fourmi.parkthat.parkmanagement.domain.model.Car;
import my.com.fourmi.parkthat.parkmanagement.domain.model.CarRepository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepositoryImpl extends JpaRepository<Car, Long>,
        CarRepository {

}
