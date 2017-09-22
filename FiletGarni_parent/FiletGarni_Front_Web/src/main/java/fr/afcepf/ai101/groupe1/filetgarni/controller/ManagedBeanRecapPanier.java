package fr.afcepf.ai101.groupe1.filetgarni.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import fr.afcepf.ai101.filetGarni.business.api.IBusinessCommande;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Produit;

@SessionScoped
@ManagedBean("mbRecapPanier")
public class ManagedBeanRecapPanier implements Serializable {

	private static final long serialVersionUID = 1L;
	@EJB
	private IBusinessCommande buCmd;
//	private List<Produit> listePdts;
//
//	public List<Produit> afficherListeProduitsPanier(){
//		
//		return listePdts;
//	}

	
}
