package fr.afcepf.ai101.groupe1.filetgarni.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.afcepf.ai101.filetGarni.business.api.IBusinessCompteUtilisateur;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Utilisateur;

@SessionScoped
@ManagedBean(name="mbConnecterConso")
public class ManagedBeanConnexionConsommateur implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EJB
	private IBusinessCompteUtilisateur buCnx;
	private Utilisateur consommateurConnecte;
	private String mail;
	private String mdp;
	
	public String seConnecter() {	
		System.out.println("se connecter");
		String page = "";
		consommateurConnecte = buCnx.seConnecterConsommateur(mail, mdp);
		if(consommateurConnecte != null) {
			System.out.println("Je suis connecté");
			page = "/commande/13Paiement/paiement.xhtml?faces-redirect=true";
			return page;
		}else {
			System.out.println("je suis null, je connais plus mes identifiants");
			page ="/connexion.xhtml?faces-redirect=true";
			return page;
		}
	}

	public IBusinessCompteUtilisateur getBuCnx() {
		return buCnx;
	}

	public void setBuCnx(IBusinessCompteUtilisateur paramBuCnx) {
		buCnx = paramBuCnx;
	}

	public Utilisateur getConsommateurConnecte() {
		return consommateurConnecte;
	}

	public void setConsommateurConnecte(Utilisateur paramConsommateurConnecte) {
		consommateurConnecte = paramConsommateurConnecte;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String paramMail) {
		mail = paramMail;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String paramMdp) {
		mdp = paramMdp;
	}
	
	

}
