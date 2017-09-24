package fr.afcepf.ai101.filetGarni.data.impl;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.ai101.filetGarni.data.api.IDaoCommande;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Commande;
import fr.afcepf.ai101.groupe1.filetGarni.entity.PointRelais;

@Remote(IDaoCommande.class)
@Stateless
public class DaoCommande implements IDaoCommande {

	@PersistenceContext(unitName = "FiletGarni_Data_Impl")
	private EntityManager em;
	
    public DaoCommande() {
    }

    public void creer(Commande paramNouvelleCommande) {
    	em.persist(paramNouvelleCommande);
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

	
}