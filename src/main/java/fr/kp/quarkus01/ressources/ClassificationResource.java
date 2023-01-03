package fr.kp.quarkus01.ressources;

import fr.kp.quarkus01.dto.ClassificationDto;
import fr.kp.quarkus01.entities.ClassificationEntity;
import fr.kp.quarkus01.repositories.ClassificationRepository;
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

@Path("/classifications")
@Tag(name = "Classifications")
@Produces(MediaType.APPLICATION_JSON)
public class ClassificationResource {

    @Inject
    ClassificationRepository classificationRepository;


    @GET
    public Response getAll(@Context UriInfo uriInfo) {
        List<ClassificationDto> classifications = new ArrayList<>();
        for (ClassificationEntity classification : classificationRepository.listAll()) {
            ClassificationDto classificationDto = new ClassificationDto(classification);
            String uriBase = uriInfo.getRequestUriBuilder().build().toString();
            classificationDto.addLink("all", uriBase);
            classificationDto.addLink("self", uriBase + "/" + classification.getId());
            classifications.add(classificationDto);
        }
        return Response.ok(classifications).build();
    }

    @GET
    @Path("{id}")
    public Response getById(@PathParam("id") Integer id, @Context UriInfo uriInfo) {
        ClassificationEntity classification = classificationRepository.findById(id);
        if (classification == null) {
            return Response.noContent().build();
        } else {
            ClassificationDto classificationDto = new ClassificationDto(classification);
            String uriBase = uriInfo.getRequestUriBuilder().build().toString();
            classificationDto.addLink("all", uriBase.replace("/" + id, ""));
            classificationDto.addLink("self", uriBase);
            return Response.ok(classificationDto).build();
        }
    }
}
