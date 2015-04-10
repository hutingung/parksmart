package my.com.fourmi.parkthat.parkmanagement.domain.model;

public interface ActivationTokenRepository {

    public ActivationToken findByPhoneNo(String phoneNo);

    public ActivationToken save(ActivationToken activationToken);
}
