package fr.afcepf.ai101.filetGarni.data.impl;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.ai101.filetGarni.data.api.IDaoTypePaiement;

@Remote(IDaoTypePaiement.class)
@Stateless
public class DaoTypePaiement implements IDaoTypePaiement {

	@PersistenceContext(unitName = "FiletGarni_Data_Impl")
	private EntityManager em;
	
    public DaoTypePaiement() {
    }

}