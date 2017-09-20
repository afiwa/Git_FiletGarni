package fr.afcepf.ai101.filetGarni.data.impl;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.ai101.filetGarni.data.api.IDaoProduit;
import fr.afcepf.ai101.groupe1.filetGarni.entity.CategorieProduit;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Producteur;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Produit;

@Remote(IDaoProduit.class)
@Stateless
public class DaoProduit implements IDaoProduit {

	@PersistenceContext(unitName = "FiletGarni_Data_Impl")
	private EntityManager em;
	
    public DaoProduit() {
    }

    public void creer() {
        // TODO implement here
    }

    public void modifier() {
        // TODO implement here
    }

    public void supprimer() {
        // TODO implement here
    }

    public void rechercher() {
        // TODO implement here
    }

    public java.util.List<Produit> getAll() {
        // TODO implement here
        return null;
    }

    public java.util.List<Produit> getByCategorie(CategorieProduit categorieProduit) {
        // TODO implement here
        return null;
    }

    public java.util.List<Produit> getByProducteur(Producteur producteur) {
        // TODO implement here
        return null;
    }

    public java.util.List<Produit> getByNom(String nom) {
        // TODO implement here
        return null;
    }

}