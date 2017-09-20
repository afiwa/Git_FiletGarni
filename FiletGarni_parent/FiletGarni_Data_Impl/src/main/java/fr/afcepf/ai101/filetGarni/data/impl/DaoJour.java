package fr.afcepf.ai101.filetGarni.data.impl;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.ai101.filetGarni.data.api.IDaoJour;

@Remote(IDaoJour.class)
@Stateless
public class DaoJour implements IDaoJour {

	@PersistenceContext(unitName = "FiletGarni_Data_Impl")
	private EntityManager em;
	
    public DaoJour() {
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

    public void rechercher() {
        // TODO implement here
    }

}