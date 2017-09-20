package fr.afcepf.ai101.filetGarni.data.impl;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.ai101.filetGarni.data.api.IDaoLivreur;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Livreur;

@Remote(IDaoLivreur.class)
@Stateless
public class DaoLivreur implements IDaoLivreur {

	@PersistenceContext(unitName = "FiletGarni_Data_Impl")
	private EntityManager em;
	
    public DaoLivreur() {
    }

    public Livreur seConnecter(String identifiantConnexion, String mdp) {
        // TODO implement here
        return null;
    }

}