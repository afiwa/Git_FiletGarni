package fr.afcepf.ai101.filetGarni.data.impl;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.ai101.filetGarni.data.api.IDaoConsommateur;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Consommateur;

@Remote(IDaoConsommateur.class)
@Stateless
public class DaoConsommateur implements IDaoConsommateur {

	@PersistenceContext(unitName = "FiletGarni_Data_Impl")
	private EntityManager em;
	
    public DaoConsommateur() {
    }

    @Override
    public Consommateur seConnecter(String mail, String mdp) {
        // TODO implement here
        return null;
    }

	@Override
	public Consommateur getById(Integer paramIdConso) {
		return (Consommateur) em.createQuery("select c from Consommateur c where c.id = :pId").setParameter("pId", paramIdConso).getSingleResult();
	}

}