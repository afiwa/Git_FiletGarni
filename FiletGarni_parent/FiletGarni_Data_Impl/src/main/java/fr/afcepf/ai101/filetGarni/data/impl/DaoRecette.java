package fr.afcepf.ai101.filetGarni.data.impl;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.ai101.filetGarni.data.api.IDaoRecette;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Recette;

@Remote(IDaoRecette.class)
@Stateless
public class DaoRecette implements IDaoRecette {

	@PersistenceContext(unitName = "FiletGarni_Data_Impl")
	private EntityManager em;
	
    public DaoRecette() {
    }
    
    @Override
    @SuppressWarnings("unchecked")
	public java.util.List<Recette> getByIdCategorieRecette(Integer id_categorie) {
        return em.createQuery("SELECT c.recettes FROM CategorieRecette c WHERE c.id = :pid")
        						.setParameter("pid", id_categorie).getResultList();
    }

    @SuppressWarnings("unchecked")
	@Override
    public java.util.List<Recette> getAllWithAllProduitRecette() {
        return em.createQuery("SELECT distinct r FROM Recette r left join fetch r.produitRecettes").getResultList();
    }


	@Override
	public Recette getByIdWithAllProduitRecette(Integer paramId_recette) {
    	return (Recette) em.createQuery("SELECT r FROM Recette r left join fetch r.produitRecettes WHERE r.id = :pid")
    			.setParameter("pid", paramId_recette).getSingleResult();
	}

}