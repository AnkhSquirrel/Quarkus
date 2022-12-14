package fr.kp.repositories;

import fr.kp.entities.FamilleEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named("FamilleRepository")
@ApplicationScoped
public class FamilleRepository implements PanacheRepositoryBase <FamilleEntity, Integer> {
}
