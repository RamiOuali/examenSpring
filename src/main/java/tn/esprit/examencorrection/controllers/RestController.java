package tn.esprit.examencorrection.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tn.esprit.examencorrection.entities.Assurance;
import tn.esprit.examencorrection.entities.Beneficiaire;
import tn.esprit.examencorrection.entities.Contrat;
import tn.esprit.examencorrection.entities.TypeContrat;
import tn.esprit.examencorrection.services.IExamen;

import java.util.Set;

@AllArgsConstructor
@org.springframework.web.bind.annotation.RestController
public class RestController {


   private IExamen iExamen;



   @PostMapping("/AddBene")
public int AddBeneficiaire(@RequestBody Beneficiaire bf) {
       return iExamen.ajouterBeneficaire(bf);
   }
    @PostMapping("/AddAssurance/{cin}")
       public int AddAssurance(@RequestBody  Assurance  a, @PathVariable  int cin){
           return   iExamen.ajouterAssurance(a,cin);

   }
    @GetMapping("/getContratAncienneBybf/{idbf}")
    public Contrat getAncienneContrat(@PathVariable  int idbf){
        return   iExamen.getContratBf(idbf);

    }
    @GetMapping("/getMontantBf/{cin}")
    public float getMontantBf(@PathVariable  int cin){
        return   iExamen.getMontantBf(cin);

    }
    @GetMapping("/getBeneficairesAsType/{TYpe}")
    public Set<Beneficiaire> GETBENEBYTYPE(@PathVariable TypeContrat TYpe){
        return  iExamen.getBeneficairesAsType(TYpe);    //xx

    }




}
