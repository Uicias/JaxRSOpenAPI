package fr.istic.taa.jaxrs.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import fr.istic.taa.jaxrs.dao.generic.SlotDAO;
import fr.istic.taa.jaxrs.dao.generic.TeacherDAO;
import fr.istic.taa.jaxrs.domain.Slot;
import io.swagger.v3.oas.annotations.Parameter;

import java.util.List;

@Path("/slot")
@Produces({"application/json", "application/xml"})
public class SlotRessource {

    SlotDAO slotDAO = new SlotDAO();
    TeacherDAO teacherDAO = new TeacherDAO();

    @GET
    @Path("/all")
    public List<Slot> getAll(){
        return slotDAO.findAll();
    }

    @GET
    @Path("/teacher/{id}")
    public List<Slot> getSlotsByTeacher(@PathParam("id") long id) {
        return this.slotDAO.findAllByTeacherId(id);
    }

}
