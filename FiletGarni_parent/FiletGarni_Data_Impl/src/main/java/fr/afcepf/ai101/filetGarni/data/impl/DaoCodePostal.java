package fr.afcepf.ai101.filetGarni.data.impl;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.ai101.filetGarni.data.api.IDaoCodePostal;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Adresse;
import fr.afcepf.ai101.groupe1.filetGarni.entity.CodePostal;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Ville;

@Remote(IDaoCodePostal.class)
@Stateless
public class DaoCodePostal implements IDaoCodePostal {

	@PersistenceContext(unitName = "FiletGarni_Data_Impl")
	private EntityManager em;
	
    public DaoCodePostal() {
    }

    public java.util.List<CodePostal> getByDepartement(Integer departement) {
        // TODO implement here
        return null;
    }

    public java.util.List<CodePostal> getByVille(Ville ville) {
        // TODO implement here
        return null;
    }

	@Override
	public CodePostal getByAdresse(Adresse paramAdresse) {
		return (CodePostal) em.createQuery("SELECT a.codePostal FROM Adresse a WHERE a.id = :pid")
				.setParameter("pid", paramAdresse.getId()).getSingleResult();
	}
}