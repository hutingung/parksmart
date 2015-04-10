package my.com.fourmi.parkthat.parkmanagement.domain.service;

import java.util.LinkedHashMap;

import my.com.fourmi.parkthat.parkmanagement.domain.model.ActivationToken;
import my.com.fourmi.parkthat.parkmanagement.domain.model.ActivationTokenRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plivo.helper.api.client.RestAPI;
import com.plivo.helper.api.response.message.MessageResponse;
import com.plivo.helper.exception.PlivoException;

@Service("clientActivationService")
public class ClientActivationServiceImpl implements ClientActivationService {

    @Autowired
    private ActivationTokenRepository activationTokenRepository;

    private static final Logger logger = LoggerFactory
            .getLogger(ClientActivationServiceImpl.class);

    public ActivationToken generateActivationToken(String phoneNo) {
        ActivationToken activationToken = activationTokenRepository
                .findByPhoneNo(phoneNo);
        if (activationToken == null) {
            activationToken = new ActivationToken(phoneNo);
        } else {
            activationToken.regenerateActivationCode();
        }
        sendSms(activationToken);
        //sendMockSms(activationToken);
        return activationToken;
    }
    
    void sendMockSms(ActivationToken activationToken) {
        logger.info("Activation Token={} ", activationToken);
    }

    void sendSms(ActivationToken activationToken) {
        logger.info("Activation Token={} ", activationToken);

        String authId = "MAMJLJMZQYMDLMZJLLYT";
        String authToken = "NjIzMmFlYzkwNDQxYjdlMGE2YmQ2YjQwZGViNjg3";
        String src = "60102319098";
        String dst = activationToken.getPhoneNo().indexOf("60") == 0 ? activationToken
                .getPhoneNo() : "60" + activationToken.getPhoneNo();

        RestAPI api = new RestAPI(authId, authToken, "v1");

        LinkedHashMap<String, String> parameters = new LinkedHashMap<String, String>();
        parameters.put("src", src);
        parameters.put("dst", dst);
        parameters.put("text", "RM0.00 ParkThat Activation Code: "
                + activationToken.getActivationCode());
        parameters.put("url", "http://server/message/notification/");

        try {
            MessageResponse msgResponse = api.sendMessage(parameters);
            logger.debug("Response API ID={}", msgResponse.apiId);
            if (msgResponse.serverCode == 202) {
                logger.debug("Successfully sent={}", msgResponse.messageUuids
                        .get(0).toString());
            } else {
                logger.debug("Response error send sms={}", msgResponse.error);
            }
        } catch (PlivoException e) {
            logger.debug("Error sending sms", e);
        }
    }

    public ActivationToken activateToken(String phoneNo, String activationCode) {
        ActivationToken activationToken = activationTokenRepository
                .findByPhoneNo(phoneNo);
        activationToken.activate(activationCode);
        activationTokenRepository.save(activationToken);
        return activationToken;
    }

}
