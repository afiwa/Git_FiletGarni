package fr.afcepf.ai101.filetGarni.data.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.ai101.filetGarni.data.api.IDaoProducteur;
import fr.afcepf.ai101.groupe1.filetGarni.entity.CategorieProducteur;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Producteur;

@Remote(IDaoProducteur.class)
@Stateless
public class DaoProducteur implements IDaoProducteur {

	@PersistenceContext(unitName = "FiletGarni_Data_Impl")
	private EntityManager em;
	
    public DaoProducteur() {
    }

    @SuppressWarnings("unchecked")
	public List<Producteur> getAll() {
    	return em.createQuery("SELECT p FROM Producteur as p left join fetch p.adresses").getResultList();
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Producteur> getAllWithCategories() {
		return em.createQuery("SELECT p FROM Producteur p left join fetch p.categories").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Producteur> getByIdCategorie(Integer paramId_categorie) {
		return em.createQuery("SELECT c.producteurs FROM CategorieProducteur c WHERE c.id = :pid")
				.setParameter("pid", paramId_categorie).getResultList();
	}
}