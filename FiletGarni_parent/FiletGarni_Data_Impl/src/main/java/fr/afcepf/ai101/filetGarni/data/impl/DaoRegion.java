package fr.afcepf.ai101.filetGarni.data.impl;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.ai101.filetGarni.data.api.IDaoRegion;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Region;

@Remote(IDaoRegion.class)
@Stateless
public class DaoRegion implements IDaoRegion {

	@PersistenceContext(unitName = "FiletGarni_Data_Impl")
	private EntityManager em;
	
    public DaoRegion() {
    }

    public java.util.List<Region> getByNom(String nom) {
        // TODO implement here
        return null;
    }

}