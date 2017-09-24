package fr.afcepf.ai101.groupe1.filetgarni.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name = "mbRecapPanier")
public class ManagedBeanRecapPanier implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value="#{mbConnecterConso}")
	private ManagedBeanConnexionConsommateur monMbCnx;

	//must povide the setter method
	public void setManagedBean(ManagedBeanConnexionConsommateur monMbCnx) {
		this.monMbCnx = monMbCnx;
	}
	
	public ManagedBeanConnexionConsommateur getMonMbCnx() {
		return monMbCnx;
	}



	public void setMonMbCnx(ManagedBeanConnexionConsommateur monMbCnx) {
		this.monMbCnx = monMbCnx;
	}



	public String RedirectConnexionOuPointRelais() {
		System.out.println("");
		if(monMbCnx.getConsommateurConnecte() == null){
			return "/commande/10Connexion/connexion.xhtml?faces-redirect=true";
		} else {
			return "/commande/13Paiement/paiement.xhtml?faces-redirect=true";
		}
	}

}
