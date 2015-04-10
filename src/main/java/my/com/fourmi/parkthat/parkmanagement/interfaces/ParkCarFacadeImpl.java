package my.com.fourmi.parkthat.parkmanagement.interfaces;

import my.com.fourmi.parkthat.parkmanagement.application.ParkCarCommand;
import my.com.fourmi.parkthat.parkmanagement.application.ParkCarService;
import my.com.fourmi.parkthat.parkmanagement.application.UnparkCarCommand;
import my.com.fourmi.parkthat.parkmanagement.domain.model.ParkCarTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("parkCarFacadeImpl")
public class ParkCarFacadeImpl implements ParkCarFacade {

    private ParkCarService parkCarService;

    @Autowired
    public void setParkCarService(ParkCarService parkCarService) {
        this.parkCarService = parkCarService;
    }

    public ParkCarResponseDTO park(ParkCarRequestDTO request) {
        ParkCarCommand command = new ParkCarCommand(request.getPhoneNo(),
                request.getPlateNo(), request.getToken());
        ParkCarTransaction parkCarTransaction = this.parkCarService
                .park(command);
        ParkCarResponseDTO response = new ParkCarResponseDTO(
                parkCarTransaction.getId(), true, "success");
        return response;
    }

    public UnparkCarResponseDTO unpark(UnparkCarRequestDTO request) {
        UnparkCarCommand command = new UnparkCarCommand(request.getPhoneNo(),
                request.getId(), request.getToken());
        ParkCarTransaction parkCarTransaction = this.parkCarService
                .unpark(command);
        UnparkCarResponseDTO response = new UnparkCarResponseDTO(
                parkCarTransaction.getId(), parkCarTransaction.getDuration(), true, "success",
                parkCarTransaction.getCharges(),
                parkCarTransaction.getClientLatestBalance());
        return response;
    }

}
