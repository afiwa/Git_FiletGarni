package fr.afcepf.ai101.groupe1.filetgarni.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.afcepf.ai101.filetGarni.business.api.IBusinessCommandeChoixPointRelais;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Consommateur;
import fr.afcepf.ai101.groupe1.filetGarni.entity.PointRelais;


@SessionScoped
@ManagedBean(name="mbChoixPRConso")
public class ManagedBeanChoixPointRelaisConsommateur implements Serializable{

	private static final long serialVersionUID = 1L;

	@EJB
	private IBusinessCommandeChoixPointRelais buChoixPointRelais;
	
	@ManagedProperty(value="#{mbConnecterConso}")
	private ManagedBeanConnexionConsommateur mbCnx;
	
	private List<PointRelais> listePR;
	private Consommateur userConnectee;
	private String adresseDomicile = "";
	private String adresseTravail = "";
	
	@PostConstruct
	private void init() {
//		listePR = buChoixPointRelais.getAllPointRelais();
//		userConnectee =(Consommateur) mbCnx.getConsommateurConnecte();
//		getConsommateurAdresseDomicile();
//		getConsommateurAdresseTravail();
	}
	
	
	
	public void getConsommateurAdresseDomicile() {
		adresseDomicile += userConnectee.getAdresses().get(0).getNumeroRue();
		adresseDomicile += userConnectee.getAdresses().get(0).getNomRue();
	}
	
	public void getConsommateurAdresseTravail() {
		if(userConnectee.getAdresses().get(1) != null) {
			adresseTravail += userConnectee.getAdresses().get(1).getNumeroRue();
			adresseTravail += userConnectee.getAdresses().get(1).getNomRue();
		}
	}
	

	public IBusinessCommandeChoixPointRelais getBuChoixPointRelais() {
		return buChoixPointRelais;
	}

	public void setBuChoixPointRelais(IBusinessCommandeChoixPointRelais buChoixPointRelais) {
		this.buChoixPointRelais = buChoixPointRelais;
	}

	public ManagedBeanConnexionConsommateur getMbCnx() {
		return mbCnx;
	}

	public void setMbCnx(ManagedBeanConnexionConsommateur mbCnx) {
		this.mbCnx = mbCnx;
	}

	public List<PointRelais> getListePR() {
		return listePR;
	}

	public void setListePR(List<PointRelais> listePR) {
		this.listePR = listePR;
	}


	public Consommateur getUserConnectee() {
		return userConnectee;
	}

	public void setUserConnectee(Consommateur userConnectee) {
		this.userConnectee = userConnectee;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getAdresseDomicile() {
		return adresseDomicile;
	}

	public void setAdresseDomicile(String adresseDomicile) {
		this.adresseDomicile = adresseDomicile;
	}

	public String getAdresseTravail() {
		return adresseTravail;
	}

	public void setAdresseTravail(String adresseTravail) {
		this.adresseTravail = adresseTravail;
	}
	
	
}
