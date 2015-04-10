package my.com.fourmi.parkthat.parkmanagement;

import java.util.LinkedHashMap;

import org.junit.Test;

import com.plivo.helper.api.client.RestAPI;
import com.plivo.helper.api.response.message.MessageResponse;
import com.plivo.helper.exception.PlivoException;

public class SendMessageTest {

    @Test
    public void test() {// TODO Auto-generated method stub
        String authId = "MAMJLJMZQYMDLMZJLLYT";
        String authToken = "NjIzMmFlYzkwNDQxYjdlMGE2YmQ2YjQwZGViNjg3";
        String src = "60102319098";
        String dst = "60168081440";

        RestAPI api = new RestAPI(authId, authToken, "v1");

        LinkedHashMap<String, String> parameters = new LinkedHashMap<String, String>();
        parameters.put("src", src);
        parameters.put("dst", dst);
        parameters.put("text", "Hello");
        parameters.put("url", "http://server/message/notification/");

        try {
            MessageResponse msgResponse = api.sendMessage(parameters);
            System.out.println(msgResponse.apiId);
            if (msgResponse.serverCode == 202) {
                System.out.println(msgResponse.messageUuids.get(0).toString());
            } else {
                System.out.println(msgResponse.error);
            }
        } catch (PlivoException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

}
