package my.com.fourmi.parkthat.parkmanagement.domain.service;

import my.com.fourmi.parkthat.parkmanagement.domain.model.ActivationToken;

public interface ClientActivationService {

    public ActivationToken generateActivationToken(String phoneNo);

    public ActivationToken activateToken(String phoneNo, String activationCode);

}
