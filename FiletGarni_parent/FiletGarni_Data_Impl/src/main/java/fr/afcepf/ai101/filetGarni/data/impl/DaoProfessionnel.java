package fr.afcepf.ai101.filetGarni.data.impl;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.ai101.filetGarni.data.api.IDaoProfessionnel;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Professionnel;

@Remote(IDaoProfessionnel.class)
@Stateless
public class DaoProfessionnel implements IDaoProfessionnel {

	@PersistenceContext(unitName = "FiletGarni_Data_Impl")
	private EntityManager em;
	
    public DaoProfessionnel() {
    }

    public void selectionner() {
        // TODO implement here
    }

    public Professionnel seConnecter(String identifiantConnexion, String mdp) {
        // TODO implement here
        return null;
    }

}