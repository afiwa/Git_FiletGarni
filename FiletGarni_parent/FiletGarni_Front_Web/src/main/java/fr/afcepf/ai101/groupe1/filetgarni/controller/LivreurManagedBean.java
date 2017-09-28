package fr.afcepf.ai101.groupe1.filetgarni.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.afcepf.ai101.filetGarni.business.api.IBusinessLivreur;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Commande;
import fr.afcepf.ai101.groupe1.filetGarni.entity.LigneCommande;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Livreur;
import fr.afcepf.ai101.groupe1.filetGarni.entity.PointRelais;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Producteur;

@SessionScoped
@ManagedBean(name="mbLivreur")
public class LivreurManagedBean {
	
	@EJB
	private IBusinessLivreur buLivreur;
	
	private Map<Producteur, List<LigneCommande>> producteurLgnCmd = new HashMap<>();
	
	private Map<PointRelais, List<Commande>> pointRelaisCmd = new HashMap<>();
	
	private Livreur livreurConnectee;
	
	private Calendar myCal = Calendar.getInstance();
	
	
	@PostConstruct
	public void init(){
		initLivreur();
		initialisationMap();
	}

	public void initialisationMap(){
		
		producteurLgnCmd = buLivreur.afficherTourneeProducteur(livreurConnectee);

		pointRelaisCmd = buLivreur.afficherTourneePointRelais(livreurConnectee);
	}
	
	public void initLivreur() {
		livreurConnectee = buLivreur.getLivreurById(111);
	}
	
	public Livreur getLivreurConnectee() {
		return livreurConnectee;
	}

	public void setLivreurConnectee(Livreur livreurConnectee) {
		this.livreurConnectee = livreurConnectee;
	}


	public IBusinessLivreur getBuLivreur() {
		return buLivreur;
	}

	public void setBuLivreur(IBusinessLivreur buLivreur) {
		this.buLivreur = buLivreur;
	}

	public Map<Producteur, List<LigneCommande>> getProducteurLgnCmd() {
		return producteurLgnCmd;
	}

	public void setProducteurLgnCmd(Map<Producteur, List<LigneCommande>> param_producteurLgnCmd) {
		producteurLgnCmd = param_producteurLgnCmd;
	}

	public Map<PointRelais, List<Commande>> getPointRelaisCmd() {
		return pointRelaisCmd;
	}

	public void setPointRelaisCmd(Map<PointRelais, List<Commande>> param_pointRelaisCmd) {
		pointRelaisCmd = param_pointRelaisCmd;
	}

	
}
