package my.com.fourmi.parkthat.parkmanagement.application;

import my.com.fourmi.parkthat.parkmanagement.AbstractParkmanagementIntegrationTest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ParkCarServiceImplTest extends
        AbstractParkmanagementIntegrationTest {

    @Autowired
    private ParkCarService parkCarService;

    @Test
    public void test() {
        ParkCarCommand command = new ParkCarCommand("0168081440", "1234",
                "WVR2600");
        try {
            parkCarService.park(command);
        } catch (RuntimeException e) {
            e.printStackTrace();
            
        }
    }

}
