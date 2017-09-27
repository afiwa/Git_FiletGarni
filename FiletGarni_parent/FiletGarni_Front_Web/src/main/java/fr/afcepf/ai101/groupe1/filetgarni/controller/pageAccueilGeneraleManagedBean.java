package fr.afcepf.ai101.groupe1.filetgarni.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean(name = "mbPageAccueilGenerale")
public class pageAccueilGeneraleManagedBean {
	
	public String choisirRegion() {
		return "/pageAccueilConsommateur/pageAccueilConsommateur.xhtml?faces-redirect=true";
	}
	
	public String redirectionPageAccueilGenerale() {
		return "/pageAccueilGenerale/pageAccueilGenerale.xhtml?faces-redirect=true";
	}
}
