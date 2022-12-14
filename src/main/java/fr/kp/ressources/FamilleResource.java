package fr.kp.ressources;

import fr.kp.entities.FamilleEntity;
import fr.kp.repositories.FamilleRepository;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/familles")
@Tag(name = "Familles")
@Produces (MediaType.APPLICATION_JSON)
public class FamilleResource {

    @Inject
    FamilleRepository familleRepository;

    @GET
    public Response getAll(){
        List<FamilleEntity> familles = familleRepository.listAll();
        return Response.ok(familles).build();
    }

    @GET
    @Path("{id}")
    public Response getById(@PathParam("id") Integer id){
        FamilleEntity famille = familleRepository.findById(id);
        return Response.ok(famille).build();
    }

    @GET
    public Response getAAA(){
        List<FamilleEntity> familles = familleRepository.listAll();
        return Response.ok(familles).build();
    }
}
