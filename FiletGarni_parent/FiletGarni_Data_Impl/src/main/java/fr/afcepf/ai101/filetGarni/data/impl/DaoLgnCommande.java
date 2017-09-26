package fr.afcepf.ai101.filetGarni.data.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.ai101.filetGarni.data.api.IDaoLgnCommande;
import fr.afcepf.ai101.groupe1.filetGarni.entity.LigneCommande;

@Remote(IDaoLgnCommande.class)
@Stateless
public class DaoLgnCommande implements IDaoLgnCommande {

	@PersistenceContext(unitName = "FiletGarni_Data_Impl")
	private EntityManager em;
	
    public DaoLgnCommande() {
    }

    public void creerUneLigneCommande(LigneCommande nouvelleLgnCmde) {
        em.persist(nouvelleLgnCmde);
    }

    public LigneCommande ajouter(Integer id_commande) {
        // TODO implement here
        return null;
    }

    public void supprimer() {
        // TODO implement here
    }

    public LigneCommande updateQuantite(Double quantite) {
        // TODO implement here
        return null;
    }

    public java.util.List<LigneCommande> getByCommande(Integer id) {
        // TODO implement here
        return null;
    }

    public java.util.List<LigneCommande> getByProducteur(Integer id_Producteur) {
        // TODO implement here
        return null;
    }

    public LigneCommande updateDatePreparation() {
        // TODO implement here
        return null;
    }

    public LigneCommande updateDateRecuperationLivreur() {
        // TODO implement here
        return null;
    }

    public LigneCommande updateDateRecuperationClient() {
        // TODO implement here
        return null;
    }

    public void signalerRetardLivraison() {
        // TODO implement here
    }
    
	@SuppressWarnings("unchecked")
	@Override
	public List<LigneCommande> getLignesCommandeByIdCommmande(Integer id_commande) {
		return em.createQuery("select l from LigneCommande l where l.commande.id = :pId").setParameter("pId", id_commande).getResultList();
	}

}