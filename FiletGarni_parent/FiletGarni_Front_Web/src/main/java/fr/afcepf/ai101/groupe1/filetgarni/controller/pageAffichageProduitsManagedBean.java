package fr.afcepf.ai101.groupe1.filetgarni.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.afcepf.ai101.filetGarni.business.api.IBusinessCommande;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Produit;

@SessionScoped
@ManagedBean(name = "mbPageAffichageProduits")
public class pageAffichageProduitsManagedBean {
	
	private List<Produit> tousLesProduits = new ArrayList<>();
	
	@EJB
	IBusinessCommande businessCommande;
	
	@PostConstruct
	public void init() {
		recupererTousLesProduits();
		
	}
	
	public void recupererTousLesProduits() {
		tousLesProduits = businessCommande.getAllProduits();
	}
	
	
	
	// Get et Set
	
	public List<Produit> getTousLesProduits() {
		return tousLesProduits;
	}

	public void setTousLesProduits(List<Produit> paramTousLesProduits) {
		tousLesProduits = paramTousLesProduits;
	}
}
