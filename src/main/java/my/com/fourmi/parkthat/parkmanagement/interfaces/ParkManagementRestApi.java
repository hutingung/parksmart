package my.com.fourmi.parkthat.parkmanagement.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

public class ParkManagementRestApi {

    @POST
    @Path("/client/register")
    @Consumes("application/json")
    @Produces("application/json")
    public RegisterClientResponseDTO client_register(
            RegisterClientRequestDTO request) {
        return null;
    }

    @POST
    @Path("/client/activate")
    @Consumes("application/json")
    @Produces("application/json")
    public ActivateClientResponseDTO client_activate(
            ActivateClientRequestDTO request) {
        return null;
    }

    @POST
    @Path("/parkcar/park")
    @Consumes("application/json")
    @Produces("application/json")
    public ParkCarResponseDTO parkcar_park(ParkCarRequestDTO request) {
        return null;
    }

    @POST
    @Path("/parkcar/unpark")
    @Consumes("application/json")
    @Produces("application/json")
    public UnparkCarResponseDTO parkcar_unpark(UnparkCarRequestDTO request) {
        return null;
    }
}
