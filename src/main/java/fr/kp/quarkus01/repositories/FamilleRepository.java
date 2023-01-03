package fr.kp.quarkus01.repositories;

import fr.kp.quarkus01.entities.FamilleEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.List;

@Named("FamilleRepository")
@ApplicationScoped
public class FamilleRepository implements PanacheRepositoryBase <FamilleEntity, Integer> {

    public List<FamilleEntity> getFamillesByClassification(String idClassification){
        return list("id_classification = ?1 ", idClassification);
    }

}
