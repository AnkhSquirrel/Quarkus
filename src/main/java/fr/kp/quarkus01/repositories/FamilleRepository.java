package fr.kp.quarkus01.repositories;

import fr.kp.quarkus01.entities.FamilleEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named("FamilleRepository")
@ApplicationScoped
public class FamilleRepository implements PanacheRepositoryBase <FamilleEntity, Integer> {
}
