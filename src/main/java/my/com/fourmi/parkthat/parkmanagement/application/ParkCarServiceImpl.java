package my.com.fourmi.parkthat.parkmanagement.application;

import java.util.List;

import my.com.fourmi.parkthat.parkmanagement.domain.model.Car;
import my.com.fourmi.parkthat.parkmanagement.domain.model.CarPark;
import my.com.fourmi.parkthat.parkmanagement.domain.model.CarParkRepository;
import my.com.fourmi.parkthat.parkmanagement.domain.model.CarRepository;
import my.com.fourmi.parkthat.parkmanagement.domain.model.Client;
import my.com.fourmi.parkthat.parkmanagement.domain.model.ClientRepository;
import my.com.fourmi.parkthat.parkmanagement.domain.model.ParkCarTransaction;
import my.com.fourmi.parkthat.parkmanagement.domain.model.ParkCarTransactionRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("parkCarServiceImpl")
public class ParkCarServiceImpl implements ParkCarService {

    private static final Logger logger = LoggerFactory
            .getLogger(ParkCarServiceImpl.class);

    private ClientRepository clientRepository;

    private CarRepository carRepository;

    private CarParkRepository carParkRepository;

    private ParkCarTransactionRepository parkCarTransactionRepository;

    @Transactional
    public ParkCarTransaction park(ParkCarCommand command) {
        Client client = this.clientRepository.findByPhoneNumber(command
                .getPhoneNo());
        if (client == null) {
            throw new RuntimeException("Client not registered");
        }
        if (client.isValidToken(command.getToken())) {
            Car car = this.carRepository.findByPlateNo(command.getPlateNo());
            if (car == null) {
                car = new Car(command.getPlateNo());
            }
            this.carRepository.save(car);
            CarPark carPark = this.carParkRepository.findByCode("SIBU");
            ParkCarTransaction parkCarTransaction = client
                    .parkCar(car, carPark);
            this.parkCarTransactionRepository.save(parkCarTransaction);
            return parkCarTransaction;
        } else {
            throw new RuntimeException("Invalid token");
        }
    }

    @Transactional
    public ParkCarTransaction unpark(UnparkCarCommand command) {
        Client client = this.clientRepository.findByPhoneNumber(command
                .getPhoneNo());
        if (client.isValidToken(command.getToken())) {
            ParkCarTransaction parkCarTransaction = this.parkCarTransactionRepository
                    .findById(command.getId());
            client.unparkCar(parkCarTransaction);
            this.parkCarTransactionRepository.save(parkCarTransaction);
            return parkCarTransaction;
        } else {
            throw new RuntimeException("Invalid token");
        }
    }

    public List<Car> searchParkedCar(String plateNo) {
        List<Car> result = this.carRepository.searchParkedCarByPlateNo(plateNo);
        logger.debug("result={}", result);
        return result;
    }

    @Autowired
    public void setClientRepository(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Autowired
    public void setCarRepository(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Autowired
    public void setCarParkRepository(CarParkRepository carParkRepository) {
        this.carParkRepository = carParkRepository;
    }

    @Autowired
    public void setParkCarTransactionRepository(
            ParkCarTransactionRepository parkCarTransactionRepository) {
        this.parkCarTransactionRepository = parkCarTransactionRepository;
    }

}
