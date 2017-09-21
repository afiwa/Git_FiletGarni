package fr.afcepf.ai101.filetGarni.data.impl;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.ai101.filetGarni.data.api.IDaoTourneeReelleLivraison;
import fr.afcepf.ai101.filetGarni.data.api.IDaoTourneeReelleProducteur;

@Remote(IDaoTourneeReelleLivraison.class)
@Stateless
public class DaoTourneeReelleLivraison implements IDaoTourneeReelleLivraison {

	@PersistenceContext(unitName = "FiletGarni_Data_Impl")
	private EntityManager em;
	
    public DaoTourneeReelleLivraison() {
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