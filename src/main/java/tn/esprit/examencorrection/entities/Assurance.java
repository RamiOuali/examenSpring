package tn.esprit.examencorrection.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity

public class Assurance {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private  int idAssurance;
private String designation;
private  float montant;


@ManyToOne
private Beneficiaire beneficiare;

@ManyToOne
  private Contrat contrat;



}
