package fr.afcepf.ai101.filetGarni.data.impl;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.ai101.filetGarni.data.api.IDaoAdresse;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Adresse;
import fr.afcepf.ai101.groupe1.filetGarni.entity.CodePostal;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Ville;

@Remote(IDaoAdresse.class)
@Stateless
public class DaoAdresse implements IDaoAdresse {
	
	@PersistenceContext(unitName = "FiletGarni_Data_Impl")
	private EntityManager em;

    public DaoAdresse() {
    }

    public java.util.List<Adresse> getByCP(CodePostal codePostal) {
        // TODO implement here
        return null;
    }

    public java.util.List<Adresse> getByVille(Ville ville) {
        // TODO implement here
        return null;
    }

}