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
    

    public java.util.List<Recette> getByCategorieRecette(Integer id_Categorie_Produit) {
        // TODO implement here
        return null;
    }

    public java.util.List<Recette> getAll() {
        // TODO implement here
        return null;
    }


	@Override
	public Recette getByIdWithAllProduitRecette(Integer paramId_recette) {
    	return (Recette) em.createQuery("SELECT r FROM Recette r left join fetch r.produitRecettes WHERE r.id = :pid")
    			.setParameter("pid", paramId_recette).getSingleResult();
	}

}