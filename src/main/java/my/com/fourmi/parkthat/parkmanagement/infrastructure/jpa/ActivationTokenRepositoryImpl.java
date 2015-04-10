package my.com.fourmi.parkthat.parkmanagement.infrastructure.jpa;

import my.com.fourmi.parkthat.parkmanagement.domain.model.ActivationToken;
import my.com.fourmi.parkthat.parkmanagement.domain.model.ActivationTokenRepository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivationTokenRepositoryImpl extends
        JpaRepository<ActivationToken, Long>, ActivationTokenRepository {

}
