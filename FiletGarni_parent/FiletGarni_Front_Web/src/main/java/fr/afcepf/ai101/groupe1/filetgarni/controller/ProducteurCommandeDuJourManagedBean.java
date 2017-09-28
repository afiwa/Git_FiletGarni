package fr.afcepf.ai101.groupe1.filetgarni.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.afcepf.ai101.filetGarni.business.api.IBusinessProducteur;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Commande;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Conditionnement;
import fr.afcepf.ai101.groupe1.filetGarni.entity.LigneCommande;

@SessionScoped
@ManagedBean(name="mbProducteurCommandeDuJour")
public class ProducteurCommandeDuJourManagedBean {
	private Set<Commande> commandesDuJour = new HashSet<>();
	private List<Commande> listeCommandesDuJour = new ArrayList<>();
	private List<LigneCommande> lignesDeCommandesDuJour = new ArrayList<>();
	private Double nbArticles = new Double(0);
	private Date dateEnlevement;
	private Map<Integer, Double> listeNbArticles = new HashMap<>();
	private DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	private String dateEnlevemeentString;
	
	@EJB
	IBusinessProducteur businessProducteur;
	
	public String afficherLesCommandesDuJour() {
		listeCommandesDuJour.clear();
		List<Conditionnement> conditionnements = new ArrayList<>();
		Calendar myCal = Calendar.getInstance();
		myCal.set(2017, 8, 30, 00, 00, 00);
		Date dateLivraisonPresentation = myCal.getTime(); 
		myCal.add(Calendar.DAY_OF_MONTH, -1);
		dateEnlevement = myCal.getTime();
		dateEnlevemeentString = formatter.format(dateEnlevement);
		commandesDuJour = businessProducteur.getCommandesByIdProducteurByDateLivraison(35, dateLivraisonPresentation);
		for (Commande commande : commandesDuJour) {
			Double nbArticlesCommande = new Double(0);			
			for (LigneCommande ligneCommande : commande.getLgnCommandes()) {
				nbArticlesCommande += ligneCommande.getQuantiteCommandee();
				conditionnements = businessProducteur.getConditionnementsByProduit(ligneCommande.getProduit());
				ligneCommande.getProduit().setConditionnements(conditionnements);
			}
			listeNbArticles.put(commande.getId(), nbArticlesCommande);
			listeCommandesDuJour.add(commande);
		}
		return "/producteur/commandesEnCours/commandesProducteur.xhtml?faces-redirect=true";
	}
	
	public String viderLesCommandesDuJour() {
		listeCommandesDuJour.clear();
		return "/producteur/commandesEnCours/commandesProducteur.xhtml?faces-redirect=true";
	}


	
//	GET ET SET
	public Set<Commande> getCommandesDuJour() {
		return commandesDuJour;
	}

	public void setCommandesDuJour(Set<Commande> paramCommandesDuJour) {
		commandesDuJour = paramCommandesDuJour;
	}

	public List<LigneCommande> getLignesDeCommandesDuJour() {
		return lignesDeCommandesDuJour;
	}

	public void setLignesDeCommandesDuJour(List<LigneCommande> paramLignesDeCommandesDuJour) {
		lignesDeCommandesDuJour = paramLignesDeCommandesDuJour;
	}

	public IBusinessProducteur getBusinessProducteur() {
		return businessProducteur;
	}

	public void setBusinessProducteur(IBusinessProducteur paramBusinessProducteur) {
		businessProducteur = paramBusinessProducteur;
	}



	public Double getNbArticles() {
		return nbArticles;
	}



	public void setNbArticles(Double paramNbArticles) {
		nbArticles = paramNbArticles;
	}



	public Date getDateEnlevement() {
		return dateEnlevement;
	}



	public void setDateEnlevement(Date paramDateEnlevement) {
		dateEnlevement = paramDateEnlevement;
	}



	public Map<Integer, Double> getListeNbArticles() {
		return listeNbArticles;
	}



	public void setListeNbArticles(Map<Integer, Double> paramListeNbArticles) {
		listeNbArticles = paramListeNbArticles;
	}



	public List<Commande> getListeCommandesDuJour() {
		return listeCommandesDuJour;
	}



	public void setListeCommandesDuJour(List<Commande> paramListeCommandesDuJour) {
		listeCommandesDuJour = paramListeCommandesDuJour;
	}



	public DateFormat getFormatter() {
		return formatter;
	}



	public void setFormatter(DateFormat paramFormatter) {
		formatter = paramFormatter;
	}



	public String getDateEnlevemeentString() {
		return dateEnlevemeentString;
	}



	public void setDateEnlevemeentString(String paramDateEnlevemeentString) {
		dateEnlevemeentString = paramDateEnlevemeentString;
	}	
	
	

}
