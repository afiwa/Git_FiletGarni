package fr.afcepf.ai101.filetGarni.data.impl;

import java.util.Date;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.ai101.filetGarni.data.api.IDaoTourneeReelleProducteur;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Livreur;
import fr.afcepf.ai101.groupe1.filetGarni.entity.TourneeReelleProducteur;

@Remote(IDaoTourneeReelleProducteur.class)
@Stateless
public class DaoTourneeReelleProducteur implements IDaoTourneeReelleProducteur {

	@PersistenceContext(unitName = "FiletGarni_Data_Impl")
	private EntityManager em;
	
    public DaoTourneeReelleProducteur() {
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
	public TourneeReelleProducteur getTourneeReelleProducteur(Livreur livreur, Date date) {
		return (TourneeReelleProducteur) em.createQuery("SELECT t FROM TourneeReelleProducteur t left join fetch t.lgnCommandes "
														+ "WHERE t.livreur = :pl AND t.dateTournee = :pd")
														.setParameter("pl", livreur).setParameter("pd", date).getSingleResult();
	}

}