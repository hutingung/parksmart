package my.com.fourmi.parkthat.parkmanagement.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ComponentScan(basePackages = { "my.com.fourmi.parkthat.parkmanagement" }, excludeFilters = { @Filter(Configuration.class) })
@EnableJpaRepositories(basePackages = { "my.com.fourmi.parkthat.parkmanagement.infrastructure.jpa" })
@EnableSpringConfigured
@Configuration
@EnableTransactionManagement
@ImportResource(value = { "classpath:META-INF/spring/parkManagementServiceRouteContext.xml" })
@Import(value = { JpaInfrastructureConfig.class })
public class ParkManagementConfig {

}
