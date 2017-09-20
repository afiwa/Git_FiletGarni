package fr.afcepf.ai101.filetGarni.data.impl;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.ai101.filetGarni.data.api.IDaoPeriodeDAbsence;
import fr.afcepf.ai101.groupe1.filetGarni.entity.PeriodeDAbsence;

@Remote(IDaoPeriodeDAbsence.class)
@Stateless
public class DaoPeriodeDAbsence implements IDaoPeriodeDAbsence {

	@PersistenceContext(unitName = "FiletGarni_Data_Impl")
	private EntityManager em;
	
    public DaoPeriodeDAbsence() {
    }

    public void creer() {
        // TODO implement here
    }

    public void modifier() {
        // TODO implement here
    }

    public void supprimer() {
        // TODO implement here
    }

    public java.util.List<PeriodeDAbsence> getByUtilisateur(Integer id_utilisateur) {
        // TODO implement here
        return null;
    }

}