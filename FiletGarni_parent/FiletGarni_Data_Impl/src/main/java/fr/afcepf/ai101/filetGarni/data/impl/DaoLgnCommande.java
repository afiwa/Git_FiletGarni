package fr.afcepf.ai101.filetGarni.data.impl;

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

    public void creerUnePremiereLigneCommande() {
        em.persist("INSERT INTO `lignecommande` (`id_lignecommande`, `date_validationrecupclient_lignecommande`, `date_validationrecuplivreur_lignecommande`, `date_validationprepproducteur_lignecommande`, `quantitecommande_lignecommande`, `quantitelivree_lignecommande`, `id_commande_tlignecommande`, `indispo_id_suiviindispo`, `produit_id_produit`, `id_tourneeproducteur_tlignecommande`) VALUES (NULL, NULL, NULL, NULL, '', NULL, NULL, NULL, NULL, NULL);");
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

}