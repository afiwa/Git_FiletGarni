package fr.afcepf.ai101.filetGarni.data.impl;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.ai101.filetGarni.data.api.IDaoSuiviIndisponibilite;
import fr.afcepf.ai101.groupe1.filetGarni.entity.SuiviIndisponibilite;

@Remote(IDaoSuiviIndisponibilite.class)
@Stateless
public class DaoSuiviIndisponibilite implements IDaoSuiviIndisponibilite {

	@PersistenceContext(unitName = "FiletGarni_Data_Impl")
	private EntityManager em;
	
    public DaoSuiviIndisponibilite() {
    }

    public SuiviIndisponibilite creer(Double quantiteReelle) {
        // TODO implement here
        return null;
    }

}