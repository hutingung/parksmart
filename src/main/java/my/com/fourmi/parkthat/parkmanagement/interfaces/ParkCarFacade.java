package my.com.fourmi.parkthat.parkmanagement.interfaces;

public interface ParkCarFacade {

    public ParkCarResponseDTO park(ParkCarRequestDTO request);

    public UnparkCarResponseDTO unpark(UnparkCarRequestDTO request);

    public SearchParkedCarResponseDTO searchParkedCar(
            SearchParkedCarRequestDTO request);
}
