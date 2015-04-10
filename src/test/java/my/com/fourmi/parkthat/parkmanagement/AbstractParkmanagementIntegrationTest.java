package my.com.fourmi.parkthat.parkmanagement;

import my.com.fourmi.parkthat.parkmanagement.config.ParkManagementConfig;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

@ContextConfiguration(classes = { ParkManagementConfig.class })
public abstract class AbstractParkmanagementIntegrationTest extends
        AbstractTransactionalJUnit4SpringContextTests {

    @Test
    public void testMarker() {
    }

}
