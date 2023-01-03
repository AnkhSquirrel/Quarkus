package fr.kp.quarkus01.ressources;

import fr.kp.quarkus01.dto.FamilleDto;
import fr.kp.quarkus01.entities.FamilleEntity;
import fr.kp.quarkus01.repositories.FamilleRepository;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.ArrayList;
import java.util.List;

@Path("/familles")
@Tag(name = "Familles")
@Produces(MediaType.APPLICATION_JSON)
public class FamilleResource {

    @Inject
    FamilleRepository familleRepository;

    @GET
    public Response getAll(@Context UriInfo uriInfo) {
        List<FamilleDto> familles = new ArrayList<>();
        for (FamilleEntity famille : familleRepository.listAll()) {
            FamilleDto familleDto = new FamilleDto(famille);
            String uriBase = uriInfo.getRequestUriBuilder().build().toString();
            familleDto.addLink("all", uriBase);
            familleDto.addLink("self", uriBase + "/" + famille.getId());
            familleDto.addLink("classification", uriBase.replace("/familles", "/classifications") + "/" + famille.getId_classification());
            familles.add(familleDto);
        }
        return Response.ok(familles).build();
    }

    @GET
    @Path("{id}")
    public Response getById(@PathParam("id") Integer id, @Context UriInfo uriInfo) {
        FamilleEntity famille = familleRepository.findById(id);
        if (famille == null) {
            return Response.noContent().build();
        } else {
            FamilleDto familleDto = new FamilleDto(famille);
            String uriBase = uriInfo.getRequestUriBuilder().build().toString();
            familleDto.addLink("all", uriBase.replace("/" + id, ""));
            familleDto.addLink("self", uriBase);
            return Response.ok(familleDto).build();
        }
    }

    @GET
    @Path("/classification/{id}")
    public Response getByClassification(@PathParam("id") Integer id, @Context UriInfo uriInfo) {
        List<FamilleDto> familles = new ArrayList<>();
        for (FamilleEntity famille : familleRepository.getFamillesByClassification(id.toString())) {
            FamilleDto familleDto = new FamilleDto(famille);
            String uriBase = uriInfo.getRequestUriBuilder().build().toString();
            familleDto.addLink("all", uriBase.replace("/classification/" + id, ""));
            familleDto.addLink("self", uriBase.replace("/classification/" + id, "/") +  + famille.getId());
            familleDto.addLink("classification", uriBase.replace("/familles/classification", "/classifications"));
            familles.add(familleDto);
        }
        return Response.ok(familles).build();
    }
}
