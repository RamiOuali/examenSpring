package tn.esprit.examencorrection.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Beneficiaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBenef;
    public int cin;
    private String nom ;
    private String prenom;

    private String profession;

    private float salaire;

    @OneToMany(mappedBy = "beneficiare")
     private Set<Assurance> assuranceList;
}
