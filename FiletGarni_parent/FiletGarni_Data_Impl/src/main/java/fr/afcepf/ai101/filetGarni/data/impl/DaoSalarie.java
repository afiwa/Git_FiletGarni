package fr.afcepf.ai101.filetGarni.data.impl;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.ai101.filetGarni.data.api.IDaoSalarie;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Salarie;

@Remote(IDaoSalarie.class)
@Stateless
public class DaoSalarie implements IDaoSalarie {

	@PersistenceContext(unitName = "FiletGarni_Data_Impl")
	private EntityManager em;
	
    public DaoSalarie() {
    }

	@Override
	public Salarie seConnecter(String paramIdentifiantConnexion, String paramMdp) {
		Salarie salarie = null;
		try { 
			salarie = em.createQuery( "SELECT s FROM Salarie s " + "WHERE s.identifiantConnexion = :pidentifiant " + "AND s.mdp = :pmdp", Salarie.class)
					.setParameter("pidentifiant", paramIdentifiantConnexion)
					.setParameter("pmdp", paramMdp)
					.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return salarie;
		
	}

}