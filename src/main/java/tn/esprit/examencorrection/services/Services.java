package tn.esprit.examencorrection.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.examencorrection.entities.Assurance;
import tn.esprit.examencorrection.entities.Beneficiaire;
import tn.esprit.examencorrection.entities.Contrat;
import tn.esprit.examencorrection.entities.TypeContrat;
import tn.esprit.examencorrection.repositories.RepoAssurance;
import tn.esprit.examencorrection.repositories.RepoBeneficiare;
import tn.esprit.examencorrection.repositories.RepoContrat;

import java.util.Set;
@AllArgsConstructor
@Service
public class Services implements IExamen {

    private RepoContrat repoContrat;
    private RepoAssurance repoAssurance;
    private RepoBeneficiare repoBeneficiare;

    @Override
    public int ajouterBeneficaire(Beneficiaire bf) {
        return repoBeneficiare.save(bf).getCin();

    }

    @Transactional
    @Override
    public int ajouterAssurance(Assurance a, int cinBf) {

        Beneficiaire b = repoBeneficiare.findBeneficiaireByCin(cinBf);
        a.setBeneficiare(b);
        Contrat contrat = repoContrat.save(a.getContrat());
        a.setContrat(contrat);
        return repoAssurance.save(a).getIdAssurance();
    }

    @Override
    public Contrat getContratBf(int idBf) {
        return repoContrat.contratAncienne(idBf);
    }

    @Override
    public float getMontantBf(int cinBf) {
        float montant =0;
        Set<Assurance> assurances = repoBeneficiare.findBeneficiaireByCin(cinBf).getAssuranceList();
 if(assurances.isEmpty()){
     montant= 0;
 }
        for (Assurance assurance : assurances) {
            if (assurance.getContrat().getType().equals(TypeContrat.Mensuel)) {
                montant= assurance.getMontant() * 12;
            } else if (assurance.getContrat().getType().equals(TypeContrat.Semestriel)) {
                montant= assurance.getMontant() * 2;
            } else if (assurance.getContrat().getType().equals(TypeContrat.Annuel)) {
                montant  = assurance.getMontant();

            }

        }
        return montant;
    }

    @Override
    public Set<Beneficiaire> getBeneficairesAsType(TypeContrat typeContrat) {
        return repoBeneficiare.getBeneficiaireByTypeContrat(typeContrat);
    }


}
