package fr.afcepf.ai101.filetGarni.data.impl;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.ai101.filetGarni.data.api.IDaoVille;
import fr.afcepf.ai101.groupe1.filetGarni.entity.CodePostal;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Ville;

@Remote(IDaoVille.class)
@Stateless
public class DaoVille implements IDaoVille {

	@PersistenceContext(unitName = "FiletGarni_Data_Impl")
	private EntityManager em;
	
    public DaoVille() {
    }

    public java.util.List<Ville> getByNom(String nom) {
        // TODO implement here
        return null;
    }

    public java.util.List<Ville> getByDepartement(Integer departement) {
        // TODO implement here
        return null;
    }

    public java.util.List<Ville> getByCodePostal(CodePostal codePostal) {
        // TODO implement here
        return null;
    }

}