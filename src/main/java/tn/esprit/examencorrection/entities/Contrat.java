package tn.esprit.examencorrection.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter

@Entity
public class Contrat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     int idContat;
    private String matricule;
    @Temporal(TemporalType.DATE)
    private Date dateEffect;
    @Enumerated(EnumType.STRING)
    private TypeContrat type;


}
