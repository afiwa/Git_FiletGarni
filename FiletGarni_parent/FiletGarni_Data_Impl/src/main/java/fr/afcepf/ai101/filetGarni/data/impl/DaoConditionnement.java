package fr.afcepf.ai101.filetGarni.data.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.ai101.filetGarni.data.api.IDaoConditionnement;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Conditionnement;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Produit;

@Remote(IDaoConditionnement.class)
@Stateless
public class DaoConditionnement implements IDaoConditionnement {

	@PersistenceContext(unitName = "FiletGarni_Data_Impl")
	private EntityManager em;
	
    public DaoConditionnement() {
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Conditionnement> getByProduit(Produit produit) {
		return em.createQuery("SELECT p.conditionnements FROM Produit p WHERE p.id = :pid").setParameter("pid", produit.getId()).getResultList();
	}  
}