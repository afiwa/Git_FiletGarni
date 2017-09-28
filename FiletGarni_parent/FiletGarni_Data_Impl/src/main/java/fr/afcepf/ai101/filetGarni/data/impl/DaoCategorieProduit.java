package fr.afcepf.ai101.filetGarni.data.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.ai101.filetGarni.data.api.IDaoCategorieProduit;
import fr.afcepf.ai101.groupe1.filetGarni.entity.CategorieProduit;

@Remote(IDaoCategorieProduit.class)
@Stateless
public class DaoCategorieProduit implements IDaoCategorieProduit {

	@PersistenceContext(unitName = "FiletGarni_Data_Impl")
	private EntityManager em;
	
    public DaoCategorieProduit() {
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<CategorieProduit> getCategoriesByIdCategorie(Integer paramId_categorieProduit) {
		return em.createQuery("SELECT c.categories FROM CategorieProduit c WHERE c.id = :pid")
				.setParameter("pid", paramId_categorieProduit).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CategorieProduit> getAllCategorie() {
		
		return em.createQuery("SELECT c FROM CategorieProduit c").getResultList();
	}

}