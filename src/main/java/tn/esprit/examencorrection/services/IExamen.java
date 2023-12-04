package tn.esprit.examencorrection.services;

import tn.esprit.examencorrection.entities.Assurance;
import tn.esprit.examencorrection.entities.Beneficiaire;
import tn.esprit.examencorrection.entities.Contrat;
import tn.esprit.examencorrection.entities.TypeContrat;

import java.util.Set;

public interface IExamen {

    public int ajouterBeneficaire (Beneficiaire bf);
    public int ajouterAssurance (Assurance a, int cinBf);
    public Contrat getContratBf (int idBf);
    public float getMontantBf (int cinBf);
    public Set<Beneficiaire> getBeneficairesAsType(TypeContrat typeContrat);


}
