package fr.afcepf.ai101.filetGarni.data.impl;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.ai101.filetGarni.data.api.IDaoTypePaiement;
import fr.afcepf.ai101.groupe1.filetGarni.entity.TypePaiement;

@Remote(IDaoTypePaiement.class)
@Stateless
public class DaoTypePaiement implements IDaoTypePaiement {

	@PersistenceContext(unitName = "FiletGarni_Data_Impl")
	private EntityManager em;
	
    public DaoTypePaiement() {
    }

	@Override
	public TypePaiement getById(Integer paramIdTypePaiement) {
		
		return (TypePaiement) em.createQuery("Select tp from TypePaiement tp where tp.id = :pId ").setParameter("pId", paramIdTypePaiement).getSingleResult();
	}

}