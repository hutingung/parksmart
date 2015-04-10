package my.com.fourmi.parkthat.parkmanagement.infrastructure.jpa;

import my.com.fourmi.parkthat.parkmanagement.domain.model.ParkCarTransaction;
import my.com.fourmi.parkthat.parkmanagement.domain.model.ParkCarTransactionRepository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkCarTransactionRepositoryImpl extends
        JpaRepository<ParkCarTransaction, Long>, ParkCarTransactionRepository {

}
