package fr.kp.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Classification", schema = "dbo", catalog = "CRKF")
public class ClassificationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_classification")
    private Integer id;

    @Column (name = "Classification")
    private String nom;
}
