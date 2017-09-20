package fr.afcepf.ai101.filetGarni.data.impl;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.ai101.filetGarni.data.api.IDaoEvaluation;

@Remote(IDaoEvaluation.class)
@Stateless
public class DaoEvalution implements IDaoEvaluation {
	
	@PersistenceContext(unitName = "FiletGarni_Data_Impl")
	private EntityManager em;

    public DaoEvalution() {
    }

    public void creer() {
        // TODO implement here
    }

    public void supprimer() {
        // TODO implement here
    }

    public void modifier() {
        // TODO implement here
    }

    public void rechercher(java.util.Date dateEvaluation) {
        // TODO implement here
    }

}