package fr.afcepf.ai101.filetGarni.data.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.ai101.filetGarni.data.api.IDaoHorairesOuverture;
import fr.afcepf.ai101.groupe1.filetGarni.entity.HorairesOuverture;
import fr.afcepf.ai101.groupe1.filetGarni.entity.PointRelais;

@Remote(IDaoHorairesOuverture.class)
@Stateless
public class DaoHorairesOuverture implements IDaoHorairesOuverture {

	@PersistenceContext(unitName = "FiletGarni_Data_Impl")
	private EntityManager em;
	
    public DaoHorairesOuverture() {
    }

    public void creer() {
        // TODO implement here
    }

    public void modifier() {
        // TODO implement here
    }

    public void supprimer() {
        // TODO implement here
    }

    public void rechercher() {
        // TODO implement here
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<HorairesOuverture> getByPointRelais(PointRelais pr) {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT pr.listeHorairesOuverture FROM PointRelais pr WHERE pr.id = :pid").setParameter("pid", pr.getId()).getResultList();
	}


}