package fr.kp.quarkus01.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import fr.kp.quarkus01.entities.ClassificationEntity;
import fr.kp.quarkus01.entities.FamilleEntity;
import fr.kp.quarkus01.hateoas.HateOas;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@JsonPropertyOrder({"idClassification", "classification"})
public class ClassificationDto extends HateOas {
    private int idClassification;
    private String classification;

    public ClassificationDto(ClassificationEntity classificationEntity) {
        idClassification = classificationEntity.getId();
        classification = classificationEntity.getNom();
    }

    @Getter
    @Setter
    static class Famille {
        private final int idFamille;
        private final String nomFamille;

        public Famille(FamilleEntity familleEntity) {
            idFamille = familleEntity.getId();
            nomFamille = familleEntity.getNom();
        }
    }

}
