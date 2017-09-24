package fr.afcepf.ai101.groupe1.filetgarni.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.afcepf.ai101.filetGarni.business.api.IBusinessCommande;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Producteur;

@SessionScoped
@ManagedBean(name = "mbPageAffichageProducteurs")
public class PageAffichageProducteursManagedBean {
	
	private List<Producteur> tousLesProducteurs = new ArrayList<>();
	private List<Producteur> producteursParCategorie = new ArrayList<>();
	
	@EJB
	private IBusinessCommande businnesCommande;

	@PostConstruct
	public void init() {
		afficherTousLesProducteurs();
	}
	
	public String afficherTousLesProducteurs() {
		tousLesProducteurs = businnesCommande.getAllProducteurs();
		return "/commande/fichesProducteurs/fichesProducteurs.xhtml?faces-redirect=true";
	}
	
	// GET ET SET 
	
	public List<Producteur> getTousLesProducteurs() {
		return tousLesProducteurs;
	}

	public void setTousLesProducteurs(List<Producteur> paramTousLesProducteurs) {
		tousLesProducteurs = paramTousLesProducteurs;
	}

	public List<Producteur> getProducteursParCategorie() {
		return producteursParCategorie;
	}

	public void setProducteursParCategorie(List<Producteur> paramProducteursParCategorie) {
		producteursParCategorie = paramProducteursParCategorie;
	}

	public IBusinessCommande getBusinnesCommande() {
		return businnesCommande;
	}

	public void setBusinnesCommande(IBusinessCommande paramBusinnesCommande) {
		businnesCommande = paramBusinnesCommande;
	}
	
	

}
