package my.com.fourmi.parkthat.parkmanagement.domain.model;

public interface CarParkRepository {

    public CarPark findByCode(String code);

    public CarPark save(CarPark carPark);

}
