package my.com.fourmi.parkthat.web.config;

import static my.com.myriadeas.spring.core.util.SpringEnvironmentUtil.DEV;
import my.com.fourmi.parkthat.parkmanagement.config.ParkManagementConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile(DEV)

@Import(value = { ParkManagementConfig.class})
public class ParkthatWebConfig {

}
