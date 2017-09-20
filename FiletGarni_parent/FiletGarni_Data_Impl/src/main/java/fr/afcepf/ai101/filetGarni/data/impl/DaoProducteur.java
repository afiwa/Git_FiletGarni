package fr.afcepf.ai101.filetGarni.data.impl;

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

    public java.util.List<Producteur> getByCategorie(CategorieProducteur categorieProducteur) {
        // TODO implement here
        return null;
    }

}