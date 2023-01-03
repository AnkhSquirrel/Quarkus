package fr.kp.quarkus01.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import fr.kp.quarkus01.entities.ClassificationEntity;
import fr.kp.quarkus01.entities.FamilleEntity;
import fr.kp.quarkus01.hateoas.HateOas;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonPropertyOrder({"idFamille", "famille"})
public class FamilleDto extends HateOas {
    private int idFamille;
    private String famille;

    public FamilleDto(FamilleEntity familleEntity) {
        idFamille = familleEntity.getId();
        famille = familleEntity.getNom();
    }

    public static List<FamilleDto> toFamilleDtoList (List<FamilleEntity> familleEntities){
        List<FamilleDto> familleDtoList = new ArrayList<>();
        for (FamilleEntity familleEntity : familleEntities){
            familleDtoList.add(new FamilleDto(familleEntity));
        }
        return familleDtoList;
    }

    @Getter
    @Setter
    static class Classification {
        private final int idClassification;
        private final String nomClassification;

        public Classification(ClassificationEntity classificationEntity) {
            idClassification = classificationEntity.getId();
            nomClassification = classificationEntity.getNom();
        }
    }
}
