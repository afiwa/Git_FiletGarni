package fr.afcepf.ai101.groupe1.filetgarni.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.afcepf.ai101.filetGarni.business.api.IBusinessCommande;
import fr.afcepf.ai101.filetGarni.business.api.IBusinessCommandeMarion;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Produit;

@SessionScoped
@ManagedBean(name = "mbPageAffichageProduits")
public class pageAffichageProduitsManagedBean {
	
	private List<Produit> tousLesProduits = new ArrayList<>();
	private List<Produit> produitsParCategorie = new ArrayList<>();
	

	@EJB
	IBusinessCommande businessCommande;
		
	@PostConstruct
	public void init() {
		recupererTousLesProduits();	
	}
	
	public String recupererTousLesProduits() {
		tousLesProduits = businessCommande.getAllProduits();
		return "/commande/fichesProduit/pageAffichageProduits.xhtml?faces-redirect=true";
	}
	
	public String recupererProduitsParCategorie(Integer id_categorie) {
		produitsParCategorie = businessCommande.getProduitByIdCategorie(id_categorie, true);
		return "/commande/fichesProduit/pageAffichageProduitsParCategorie.xhtml?faces-redirect=true";
	}
	public List<Produit> recupererListeProduitsParCategorie(Integer id_categorie) {
		produitsParCategorie = businessCommande.getProduitByIdCategorie(id_categorie, true);
		return produitsParCategorie ;
	}
//	public String afficherPageTousLesProduits() {
//		return "/commande/pageAffichageProduits.xhtml?faces-redirect=true";
//	}
	
	
	// Get et Set
	
	public List<Produit> getProduitsParCategorie() {
		return produitsParCategorie;
	}

	public void setProduitsParCategorie(List<Produit> paramProduitsParCategorie) {
		produitsParCategorie = paramProduitsParCategorie;
	}

	public IBusinessCommande getBusinessCommande() {
		return businessCommande;
	}

	public void setBusinessCommande(IBusinessCommande paramBusinessCommande) {
		businessCommande = paramBusinessCommande;
	}

	public List<Produit> getTousLesProduits() {
		return tousLesProduits;
	}

	public void setTousLesProduits(List<Produit> paramTousLesProduits) {
		tousLesProduits = paramTousLesProduits;
	}

	
	
	
}
