package fr.afcepf.ai101.filetGarni.data.impl;

import java.util.List;

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
    
    @Override
	public Produit getById(Integer paramId_produit) {
		return (Produit) em.createQuery("SELECT p FROM Produit p WHERE p.id = :pid").setParameter("pid", paramId_produit).getSingleResult();
	}
    
    @Override
	public Produit getByIdWithConditionnement(Integer paramId_produit) {
		return (Produit) em.createQuery("SELECT p FROM Produit p left join fetch p.conditionnements WHERE p.id = :pid").setParameter("pid", paramId_produit).getSingleResult();
	}
    
    @SuppressWarnings("unchecked")
	public java.util.List<Produit> getAllWithConditionnements() {
        return em.createQuery("SELECT p FROM Produit p left join fetch p.conditionnements").getResultList();
    }
    
    @Override
    @SuppressWarnings("unchecked")
	public java.util.List<Produit> getByIdCategorie(Integer id_categorieProduit) {
        return em.createQuery("SELECT c.produits FROM CategorieProduit c WHERE c.id = :pid").setParameter("pid", id_categorieProduit).getResultList();
    }
    
	@SuppressWarnings("unchecked")
	@Override
	public List<Produit> getByIdProducteur(Integer paramId_producteur) {
		return em.createQuery("SELECT p.produits FROM Producteur p WHERE p.id = :pid")
								.setParameter("pid", paramId_producteur)
								.getResultList();
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

    public java.util.List<Produit> getByProducteur(Producteur producteur) {
        // TODO implement here
        return null;
    }

    public java.util.List<Produit> getByNom(String nom) {
        // TODO implement here
        return null;
    }
}