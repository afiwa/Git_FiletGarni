package fr.afcepf.ai101.groupe1.filetgarni.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import fr.afcepf.ai101.filetGarni.business.api.IBusinessCommande;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Produit;

@SessionScoped
@ManagedBean(name="mbDashboardProducteur")
public class DashboardProducteurManagedBean {
	private Produit produitStockBas= new Produit();
	private List<Produit> listProduitProducteur = new ArrayList<>();
	private Integer nbProduit = new Integer(0);
	private String url;
	
	@EJB
	private IBusinessCommande businessCommande;
	
	@PostConstruct
	public void init() {
		recupererNbProduitProducteur();
	}
	
	public String afficherFicheProduitStockBas(Integer id_producteur) {
		url = FacesContext.getCurrentInstance().getViewRoot().getViewId();
		produitStockBas = businessCommande.getProduitStockBasByIdProducteur(id_producteur);		
		return "/producteur/catalogueProducteur/ficheDetailleeCatalogue.xhtml?faces-redirect=true";
	}
	
	public String retournerDashBoard() {
		return url + "?faces-redirect=true"; 
	}
	

	public String afficherProduitProducteur(Integer id_producteur) {		
		listProduitProducteur = businessCommande.getProduitsByIdProducteur(id_producteur);
		return "/producteur/fichesProduitProducteur/ficheProduitProducteur.xhtml?faces-redirect=true";
		
	}
	
	public String afficherDashboardProducteur() {
		
		return "/producteur/dashboardProducteur/dashboardProducteur.xhtml?faces-redirect=true";
	}
	
	public void recupererNbProduitProducteur () {
		listProduitProducteur = businessCommande.getProduitsByIdProducteur(35);
		nbProduit = listProduitProducteur.size();

	}
	
	public Produit recupererProduitStockBas(Integer id_producteur) {
		produitStockBas = businessCommande.getProduitStockBasByIdProducteur(id_producteur);
		return produitStockBas;
	}

	public Produit getProduitStockBas() {
		return produitStockBas;
	}

	public void setProduitStockBas(Produit produitStockBas) {
		this.produitStockBas = produitStockBas;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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


	public void setListProduitProducteur(List<Produit> listProduitProducteur) {
		this.listProduitProducteur = listProduitProducteur;
	}


	public Integer getNbProduit() {
		return nbProduit;
	}


	public void setNbProduit(Integer nbProduit) {
		this.nbProduit = nbProduit;
	}
	
	
	
	
}
