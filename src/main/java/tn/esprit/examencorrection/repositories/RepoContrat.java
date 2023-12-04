package tn.esprit.examencorrection.repositories;

import jakarta.websocket.server.PathParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.examencorrection.entities.Contrat;

public interface RepoContrat extends JpaRepository<Contrat, Integer> {



    @Query("select a.contrat from Assurance a where a.beneficiare.idBenef =:idbf order by a.contrat.dateEffect limit 1")
    public Contrat contratAncienne(@Param("idbf") int idbf);


}
//