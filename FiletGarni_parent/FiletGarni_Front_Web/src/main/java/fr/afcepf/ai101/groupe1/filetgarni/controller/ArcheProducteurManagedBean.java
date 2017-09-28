package fr.afcepf.ai101.groupe1.filetgarni.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name="mbArcheProducteur")
public class ArcheProducteurManagedBean {
	
	public String afficherDashboardProducteur() {
		return "/producteur/dashboardProducteur/dashboardProducteur.xhtml?faces-redirect=true";
	}
	
	public String afficherCmdAPreparerJourProducteur() {
		return "/producteur/commandeEnCours/commandesProducteur.xhtml?faces-redirect=true";
	}

}
