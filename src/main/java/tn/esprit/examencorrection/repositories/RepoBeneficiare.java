package tn.esprit.examencorrection.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examencorrection.entities.Beneficiaire;
import tn.esprit.examencorrection.entities.TypeContrat;

import java.util.Set;

public interface RepoBeneficiare extends JpaRepository<Beneficiaire, Integer> {

    public Beneficiaire findBeneficiaireByCin(int Cin);


    public Set<Beneficiaire> getBeneficiaireByTypeContrat(TypeContrat typeContrat);

}
