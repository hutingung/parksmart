package my.com.fourmi.parkthat.parkmanagement.data;

import java.math.BigDecimal;

import my.com.fourmi.parkthat.parkmanagement.application.ReaderInitilizationBean;
import my.com.fourmi.parkthat.parkmanagement.domain.model.CarPark;
import my.com.fourmi.parkthat.parkmanagement.domain.model.CarParkRepository;
import my.com.fourmi.parkthat.parkmanagement.domain.model.Rate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "demoReader")
public class DemoReader implements ReaderInitilizationBean {

    @Autowired
    private CarParkRepository carParkRepository;

    public void afterPropertiesSet() throws Exception {
        init();
    }

    public void init() {
        Long chargingBlock = new Long(60000 * 10);
        CarPark carPark = new CarPark("SIBU", "Sibu", "Sibu", new Rate(
                chargingBlock, new BigDecimal("0.14")));
        carParkRepository.save(carPark);

    }
}
