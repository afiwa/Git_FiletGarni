package fr.afcepf.ai101.filetGarni.data.impl;

import java.util.Date;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.ai101.filetGarni.data.api.IDaoTourneeReelleLivraison;
import fr.afcepf.ai101.filetGarni.data.api.IDaoTourneeReelleProducteur;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Livreur;
import fr.afcepf.ai101.groupe1.filetGarni.entity.TourneeReelleLivraison;
import fr.afcepf.ai101.groupe1.filetGarni.entity.TourneeReelleProducteur;

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

	@Override
	public TourneeReelleLivraison getTourneeReelleLivraison(Livreur livreur, Date date) {
		return (TourneeReelleLivraison) em.createQuery("SELECT t FROM TourneeReelleLivraison t left join fetch t.commandes "
				+ "WHERE t.livreur = :pl AND t.dateTournee = :pd")
				.setParameter("pl", livreur).setParameter("pd", date).getSingleResult();
	}

}