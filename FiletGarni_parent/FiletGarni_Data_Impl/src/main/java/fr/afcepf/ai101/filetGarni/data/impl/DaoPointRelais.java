package fr.afcepf.ai101.filetGarni.data.impl;

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

    public java.util.List<PointRelais> getByHoraireOuverture(java.util.Date debut, java.util.Date fin) {
        // TODO implement here
        return null;
    }

    public void getByHoraireOuvertureAndJour() {
        // TODO implement here
    }

}