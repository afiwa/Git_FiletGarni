package fr.afcepf.ai101.groupe1.filetgarni.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.afcepf.ai101.filetGarni.business.api.IBusinessCommande;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Recette;

@SessionScoped
@ManagedBean(name = "mbPageAffichageRecettes")
public class PageAffichageRecettesManagedBean {

	private List<Recette> toutesLesRecettes = new ArrayList<>();
	private List<Recette> recettesParCategorie = new ArrayList<>();
	
	@EJB
	IBusinessCommande businessCommande;
	
	@PostConstruct
	public void init() {
		afficherToutesLesRecettes();
	}
	
	public String afficherToutesLesRecettes() {
		toutesLesRecettes = businessCommande.getAllRecettes();
		return "/commande/fichesRecettes/fichesRecettes.xhtml?faces-redirect=true";
	}
	
	public String afficherRecettesParCategorie(Integer id_categorie) {
		recettesParCategorie = businessCommande.getRecetteByCategorie(id_categorie);
		return "/commande/fichesRecettes/pageAffichageRecettesParCategorie.xhtml?faces-redirect=true";
	}
	
	// GET ET SET
	
	public List<Recette> getToutesLesRecettes() {
		return toutesLesRecettes;
	}

	public void setToutesLesRecettes(List<Recette> paramToutesLesRecettes) {
		toutesLesRecettes = paramToutesLesRecettes;
	}

	public List<Recette> getRecettesParCategorie() {
		return recettesParCategorie;
	}

	public void setRecettesParCategorie(List<Recette> paramRecettesParCategorie) {
		recettesParCategorie = paramRecettesParCategorie;
	}

	public IBusinessCommande getBusinessCommande() {
		return businessCommande;
	}

	public void setBusinessCommande(IBusinessCommande paramBusinessCommande) {
		businessCommande = paramBusinessCommande;
	}
	
	
}
