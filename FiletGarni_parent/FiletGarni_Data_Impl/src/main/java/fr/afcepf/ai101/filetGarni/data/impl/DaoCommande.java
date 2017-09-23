package fr.afcepf.ai101.filetGarni.data.impl;

import java.sql.Date;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.ai101.filetGarni.data.api.IDaoCommande;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Commande;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Consommateur;
import fr.afcepf.ai101.groupe1.filetGarni.entity.PointRelais;
import fr.afcepf.ai101.groupe1.filetGarni.entity.TypePaiement;

@Remote(IDaoCommande.class)
@Stateless
public class DaoCommande implements IDaoCommande {

	@PersistenceContext(unitName = "FiletGarni_Data_Impl")
	private EntityManager em;
	
    public DaoCommande() {
    }

    public Commande creer(Integer paramId, Date paramDatePaiement, Date paramDateValidation, Date paramDateLivraisonPrevue, TypePaiement paramTypePaiement, PointRelais paramPointRelais, Consommateur paramConsommateur) {
    	Commande nouvelleCommande = new Commande(paramId, paramDatePaiement, paramDateValidation, paramDateLivraisonPrevue, paramTypePaiement, paramPointRelais, paramConsommateur);
    	em.persist(nouvelleCommande);
        return nouvelleCommande;
    }

    public void supprimer() {
        // TODO implement here
    }

    public void rechercher() {
        // TODO implement here
    }

    public Commande getById(Integer idCommande) {
        // TODO implement here
        return null;
    }

    public void validerCmde() {
        // TODO implement here
    }

    public void payerCmde() {
        // TODO implement here
    }

    public java.util.List<Commande> getByUtilisateur(Integer idUtilisateur) {
        // TODO implement here
        return null;
    }

    public Commande updateTypePaiement(Integer id) {
        // TODO implement here
        return null;
    }

    public Commande updateDatePaiement(Integer id) {
        // TODO implement here
        return null;
    }

    public Commande updateDatePreparation(Integer id) {
        // TODO implement here
        return null;
    }

    public Commande updateDateRecuperationClient(Integer id) {
        // TODO implement here
        return null;
    }

    public Commande updatePointRelais(PointRelais id_pointRelais) {
        // TODO implement here
        return null;
    }

	@Override
	public Commande creer() {
		// TODO Auto-generated method stub
		return null;
	}

}