package fr.istic.taa.jaxrs.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import fr.istic.taa.jaxrs.dao.generic.UserDAO;
import fr.istic.taa.jaxrs.domain.Pet;
import fr.istic.taa.jaxrs.domain.User;
import io.swagger.v3.oas.annotations.Parameter;

@Path("/user")
@Produces({"application/json", "application/xml"})
public class UserRessource {

    UserDAO userDAO = new UserDAO();

    @GET
    @Path("/{id}")
    public User getUserById(@PathParam("id") long id) {
        return userDAO.findById(id);
    }

    @POST
    @Path("/create")
    @Consumes("application/json")
    public Response createUser(
            @Parameter(description = "User object that needs to be added to the db", required = true) User user){
        userDAO.create(user);
        return Response.ok().entity("SUCCESS").build();
    }

}
