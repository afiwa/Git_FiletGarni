package fr.afcepf.ai101.filetGarni.business.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.ai101.filetGarni.business.api.IBusinessCommandeChoixPointRelais;
import fr.afcepf.ai101.filetGarni.data.api.IDaoPointRelais;
import fr.afcepf.ai101.groupe1.filetGarni.entity.PointRelais;

@Remote(IBusinessCommandeChoixPointRelais.class)
@Stateless
public class BusinessCommandeChoixPointRelais implements IBusinessCommandeChoixPointRelais {

	@EJB
	private IDaoPointRelais daoPointRelais;
	

	@Override
	public List<PointRelais> getAllPointRelais() {
		
		return daoPointRelais.getAll();
	}


	public BusinessCommandeChoixPointRelais() {
		
	}
	
	
  
}
