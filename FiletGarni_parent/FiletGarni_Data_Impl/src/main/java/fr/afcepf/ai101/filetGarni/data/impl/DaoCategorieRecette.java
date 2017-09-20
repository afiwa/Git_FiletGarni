package fr.afcepf.ai101.filetGarni.data.impl;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.ai101.filetGarni.data.api.IDaoCategorieRecette;

@Remote(IDaoCategorieRecette.class)
@Stateless
public class DaoCategorieRecette implements IDaoCategorieRecette {

	@PersistenceContext(unitName = "FiletGarni_Data_Impl")
	private EntityManager em;
	
    public DaoCategorieRecette() {
    }

}