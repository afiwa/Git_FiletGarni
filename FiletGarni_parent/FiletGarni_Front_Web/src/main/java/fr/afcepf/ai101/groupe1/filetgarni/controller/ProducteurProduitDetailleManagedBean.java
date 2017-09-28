package fr.afcepf.ai101.groupe1.filetgarni.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.afcepf.ai101.filetGarni.business.api.IBusinessCommande;
import fr.afcepf.ai101.groupe1.filetGarni.entity.CategorieProduit;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Conditionnement;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Produit;

@SessionScoped
@ManagedBean(name = "mbProducteurProduitDetaille")
public class ProducteurProduitDetailleManagedBean {
	
	private List<Conditionnement> conditionnements = new ArrayList<>();
	private List<CategorieProduit> categories = new ArrayList<>();
	private List<Produit> listProduitProducteur = new ArrayList<>();
	
	@EJB
	IBusinessCommande businessCommande;

	@PostConstruct
	public void init() {
		recupererLesConditionnements();
		recupererLesCategories();
	}	
	
	public void recupererLesConditionnements() {
		conditionnements = businessCommande.getAllConditionnements();
	}
	
	public void recupererLesCategories() {
		categories = businessCommande.getAllCategorieProduit();
	}
	
	public String supprimerUnProduitStockBas(Integer paramid_produit) {
		businessCommande.supprimerUnProduit(paramid_produit);
		return "/producteur/dashboardProducteur/dashboardProducteur.xhtml?faces-redirect=true";
	}
	
	public String supprimerUnProduitCatalogue(Integer paramid_produit) {
		businessCommande.supprimerUnProduit(paramid_produit);
		listProduitProducteur = businessCommande.getProduitsByIdProducteur(35);
		return "/producteur/fichesProduitProducteur/ficheProduitProducteur.xhtml?faces-redirect=true";
	}
	
//	GET ET SET
	public List<Conditionnement> getConditionnements() {
		return conditionnements;
	}

	public void setConditionnements(List<Conditionnement> conditionnements) {
		this.conditionnements = conditionnements;
	}

	public List<CategorieProduit> getCategories() {
		return categories;
	}

	public void setCategories(List<CategorieProduit> categories) {
		this.categories = categories;
	}

	public IBusinessCommande getBusinessCommande() {
		return businessCommande;
	}

	public void setBusinessCommande(IBusinessCommande businessCommande) {
		this.businessCommande = businessCommande;
	}

	public List<Produit> getListProduitProducteur() {
		return listProduitProducteur;
	}

	public void setListProduitProducteur(List<Produit> paramListProduitProducteur) {
		listProduitProducteur = paramListProduitProducteur;
	}	

}
