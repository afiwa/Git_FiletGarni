package fr.afcepf.ai101.groupe1.filetgarni.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import fr.afcepf.ai101.filetGarni.business.api.IBusinessCommande;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Produit;

@SessionScoped
@ManagedBean("mbRecapPanier")
public class ManagedBeanRecapPanier implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value = "#{mbTestPanier}")
	 private ManagedBeanTestPanier monMbTestPanier;
	
	@EJB
	private IBusinessCommande buCmd;
	private Double totalCommande;
	private Double totalLigneCmde;
	
	
//	public augmenterQuantite() {
//		
//	}
	
	public void diminuerQuantite() {
		System.out.println("j'ai reussi mon ajax");
		
	}
//	public supprimerLigneCommande() {
//		
//	}
	private List<Produit> listePdts;

	public List<Produit> afficherListeProduitsPanier(){
		
		return listePdts;
	}
	
	public void testPanier() {
		
	}

	
}
