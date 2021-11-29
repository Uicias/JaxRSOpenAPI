package fr.istic.taa.jaxrs.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import fr.istic.taa.jaxrs.dao.generic.TeacherDAO;
import fr.istic.taa.jaxrs.domain.Teacher;
import io.swagger.v3.oas.annotations.Parameter;

@Path("/teacher")
@Produces({"application/json", "application/xml"})
public class TeacherRessource {

    TeacherDAO teacherDAO = new TeacherDAO();

    @GET
    @Path("/{id}")
    public Teacher getTeacherById(@PathParam("id") long id) {
        return teacherDAO.findById(id);
    }

    @POST
    @Path("/create")
    @Consumes("application/json")
    public Response create(
            @Parameter(description = "Teacher object that needs to be added to the db", required = true) Teacher teacher){
        teacherDAO.create(teacher);
        return Response.ok().entity("SUCCESS").build();
    }
}
