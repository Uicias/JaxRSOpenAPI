package fr.istic.taa.jaxrs.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import fr.istic.taa.jaxrs.dao.generic.AppointmentDAO;
import fr.istic.taa.jaxrs.domain.Appointment;

import java.util.List;

@Path("/user")
@Produces({"application/json", "application/xml"})
public class AppointmentRessource {

    AppointmentDAO appointmentDAO = new AppointmentDAO();

    @GET
    @Path("/all")
    public List<Appointment> getUserById() {
        return appointmentDAO.findAll();
    }
}
