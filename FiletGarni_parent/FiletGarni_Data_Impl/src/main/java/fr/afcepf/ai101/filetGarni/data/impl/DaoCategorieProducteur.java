package fr.afcepf.ai101.filetGarni.data.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.ai101.filetGarni.data.api.IDaoCategorieProducteur;
import fr.afcepf.ai101.groupe1.filetGarni.entity.CategorieProducteur;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Producteur;

@Remote(IDaoCategorieProducteur.class)
@Stateless
public class DaoCategorieProducteur implements IDaoCategorieProducteur {

	@PersistenceContext(unitName = "FiletGarni_Data_Impl")
	private EntityManager em;
	
    public DaoCategorieProducteur() {
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<CategorieProducteur> getCategoriesByProducteur(Producteur producteur) {
		return em.createQuery("SELECT p.categories FROM Producteur p WHERE p.id = :pid")
				.setParameter("pid", producteur.getId()).getResultList();
	}
}