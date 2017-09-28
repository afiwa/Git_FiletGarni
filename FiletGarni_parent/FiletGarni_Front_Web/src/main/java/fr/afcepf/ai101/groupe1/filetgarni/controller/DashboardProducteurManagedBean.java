package fr.afcepf.ai101.groupe1.filetgarni.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import fr.afcepf.ai101.filetGarni.business.api.IBusinessCommande;
import fr.afcepf.ai101.filetGarni.business.api.IBusinessProducteur;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Commande;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Produit;

@SessionScoped
@ManagedBean(name="mbDashboardProducteur")
public class DashboardProducteurManagedBean {
	private Produit produitStockBas= new Produit();
	private List<Produit> listProduitProducteur = new ArrayList<>();
	private Integer nbProduit = new Integer(0);
	private String url;
	private Set<Commande> commandesJourAPreparer = new HashSet<>();
	private Calendar myCal = Calendar.getInstance();
	private int NbCommandesAPreparer;
	
	@EJB
	private IBusinessCommande businessCommande;
	
	@EJB
	private IBusinessProducteur businessProducteur;
	
	@PostConstruct
	public void init() {
		recupererNbProduitProducteur();
	}
	
	public int recupererNbCmdAPrepDuJour() {
		myCal.set(2017, 8, 30, 00, 00, 00);
		Date dateLivraisonPresentation = myCal.getTime(); 
		commandesJourAPreparer = businessProducteur.getCommandesByIdProducteurByDateLivraison(35, dateLivraisonPresentation);
		NbCommandesAPreparer = commandesJourAPreparer.size();	
		return NbCommandesAPreparer;
	}
	
	public String afficherFicheProduitStockBas(Integer id_producteur) {
		url = FacesContext.getCurrentInstance().getViewRoot().getViewId();
		produitStockBas = businessCommande.getProduitStockBasByIdProducteur(id_producteur);		
		return "/producteur/catalogueProducteur/ficheDetailleeCatalogue.xhtml?faces-redirect=true";
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
	
	public String retournerDashBoard() {
		return url + "?faces-redirect=true"; 
	}
	

	public String afficherProduitProducteur(Integer id_producteur) {		
		listProduitProducteur = businessCommande.getProduitsByIdProducteur(id_producteur);
		System.out.println("nombre de produit" + listProduitProducteur.size());
		return "/producteur/fichesProduitProducteur/ficheProduitProducteur.xhtml?faces-redirect=true";
		
	}
	
	public String afficherDashboardProducteur() {
		
		return "/producteur/dashboardProducteur/dashboardProducteur.xhtml?faces-redirect=true";
	}
	
	public void recupererNbProduitProducteur () {
		listProduitProducteur = businessCommande.getProduitsByIdProducteur(35);
		nbProduit = listProduitProducteur.size();
		System.out.println("nb produit =" + nbProduit);

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

	public Set<Commande> getCommandesJourAPreparer() {
		return commandesJourAPreparer;
	}

	public void setCommandesJourAPreparer(Set<Commande> commandesJourAPreparer) {
		this.commandesJourAPreparer = commandesJourAPreparer;
	}

	public Calendar getMyCal() {
		return myCal;
	}

	public void setMyCal(Calendar myCal) {
		this.myCal = myCal;
	}

	public int getNbCommandesAPreparer() {
		return NbCommandesAPreparer;
	}

	public void setNbCommandesAPreparer(int nbCommandesAPreparer) {
		NbCommandesAPreparer = nbCommandesAPreparer;
	}

	public IBusinessProducteur getBusinessProducteur() {
		return businessProducteur;
	}

	public void setBusinessProducteur(IBusinessProducteur businessProducteur) {
		this.businessProducteur = businessProducteur;
	}	
	
	
	
}
