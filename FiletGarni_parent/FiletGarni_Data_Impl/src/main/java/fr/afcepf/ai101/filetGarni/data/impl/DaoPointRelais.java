package fr.afcepf.ai101.filetGarni.data.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.ai101.filetGarni.data.api.IDaoPointRelais;
import fr.afcepf.ai101.groupe1.filetGarni.entity.PointRelais;

@Remote(IDaoPointRelais.class)
@Stateless
public class DaoPointRelais implements IDaoPointRelais {

	@PersistenceContext(unitName = "FiletGarni_Data_Impl")
	private EntityManager em;
	
    public DaoPointRelais() {
    }

    public java.util.List<PointRelais> getByJour(String jour) {
        // TODO implement here
        return null;
    }

    @SuppressWarnings("unchecked")
	public java.util.List<PointRelais> getByHoraireOuverture(java.util.Date debut, java.util.Date fin) {
        // TODO implement here
        return em.createQuery("SELECT p "
		+ "FROM PointRelais p "
		+ "left join fetch p.horairesouverture").getResultList();
    }

	@Override
	public void getByHoraireOuvertureAndJour(String jour, Date debut, Date fin) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PointRelais> getAll() {
		return em.createQuery("SELECT p "
				+ "FROM PointRelais as p "
				+ "left join fetch p.adresses").getResultList();
	}

	@Override
	public PointRelais getById(Integer paramIdPointRelais) {
		return (PointRelais) em.createQuery("select pr from PointRelais pr where id = :pId").setParameter("pId", paramIdPointRelais).getSingleResult();
	}

}