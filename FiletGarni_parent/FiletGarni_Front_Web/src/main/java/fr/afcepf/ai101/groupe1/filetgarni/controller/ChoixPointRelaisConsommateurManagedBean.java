package fr.afcepf.ai101.groupe1.filetgarni.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.afcepf.ai101.filetGarni.business.api.IBusinessCommandeChoixPointRelais;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Consommateur;
import fr.afcepf.ai101.groupe1.filetGarni.entity.HorairesOuverture;
import fr.afcepf.ai101.groupe1.filetGarni.entity.PointRelais;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Utilisateur;

@SessionScoped
@ManagedBean(name="mbChoixPRConso")
public class ChoixPointRelaisConsommateurManagedBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private List<PointRelais> tousLesPointRelais = new ArrayList<>();
	
	/*@ManagedProperty(value = "mbConnecterConso")
	private ManagedBeanConnexionConsommateur mbConnecterConso;*/

	private Consommateur user = new Consommateur();
	
	/* Parti simulation */
	String adresseDomicile ="7-9 Rue Gathelot, 92140 Clamart, France";
	String longitudeDomicile ="2.2649";
	String latitudeDomicile = "48.798723";
	String adresseTravail ="26 Rue du Quatre Septembre, 75002 Paris, France";
	String longitudeTravail ="2.333908";
	String latitudeTravail = "48.870135";
	/*Fin Simulation*/
	@EJB
	IBusinessCommandeChoixPointRelais businessPr;
	
	@PostConstruct
	public void init() {
		//user = (Consommateur) mbConnecterConso.getConsommateurConnecte();
		recupererTousLesPointRelais();
	}
	
	public String jsonPointRelais() {
		StringBuilder jsonPointRelais = new StringBuilder();
		String longitude;
		String latitude;
		String position;
		String nom;
		String adresse;
		String numRue;
		String nomRue;
		String ville;
		String cp;
		Double distanceDomicile;
		Double distanceTravail;
		List<String> jour = new ArrayList<>();
		List<String> horairedebut= new ArrayList<>();
		List<String> horairefin= new ArrayList<>();

		for (PointRelais pr : tousLesPointRelais) {
			longitude = pr.getAdresses().get(0).getLongitude();
			latitude = pr.getAdresses().get(0).getLatitude();
			position = "new google.maps.LatLng("+latitude+","+longitude+")";
			/*distanceDomicile = businessPr.DistanceEntreDeuxPointRelais(Double.parseDouble(user.getAdresses().get(0).getLatitude()), 
																		Double.parseDouble(user.getAdresses().get(0).getLongitude()),
																		Double.parseDouble(latitude),
																		Double.parseDouble(longitude));
			if(user.getAdresses().get(1) != null) {
				distanceTravail = businessPr.DistanceEntreDeuxPointRelais(Double.parseDouble(user.getAdresses().get(1).getLatitude()), 
																			Double.parseDouble(user.getAdresses().get(1).getLongitude()),
																			Double.parseDouble(latitude),
																			Double.parseDouble(longitude));
			}*/
			distanceDomicile = businessPr.DistanceEntreDeuxPointRelais(Double.parseDouble(latitudeDomicile), 
					Double.parseDouble(longitudeDomicile),
					Double.parseDouble(latitude),
					Double.parseDouble(longitude));
			distanceTravail = businessPr.DistanceEntreDeuxPointRelais(Double.parseDouble(latitudeTravail), 
					Double.parseDouble(longitudeTravail),
					Double.parseDouble(latitude),
					Double.parseDouble(longitude));
			nom = pr.getRaisonSociale();
			ville = pr.getAdresses().get(0).getCodePostal().getVilles().get(0).getNom();
			cp = pr.getAdresses().get(0).getCodePostal().getCodePostal();
			numRue = pr.getAdresses().get(0).getNumeroRue();
			nomRue = pr.getAdresses().get(0).getNomRue();
			jour.clear();
			horairedebut.clear();
			horairefin.clear();
			for(HorairesOuverture ho :pr.getListeHorairesOuverture()) {
				jour.add(ho.getJour().getLibelle());
				horairedebut.add(ho.getHeureDeDébut());
				horairefin.add(ho.getHeureDeFin());
			}
			if(numRue != null) {
				adresse = numRue + " " + nomRue;
			}
			else {
				adresse = nomRue;
			}	
			jsonPointRelais.append("{")
					.append("position:" + position + ",")
					.append("nom:\"" + nom + "\",")
					.append("adresse:\"" + adresse + "\",")
					.append("ville:\"" + ville + "\",")
					.append("cp:'" + cp + "',")
					.append("distanceDomicile: "+distanceDomicile.toString() +",")
					.append("distanceTravail: "+distanceTravail.toString() +",")
					.append("distance: 0,")
					.append("listehoraires : { ");
					for(int i = 0; i< jour.size();i++) {
						jsonPointRelais.append("horaire"+i+": {")
						.append("jour:'"+jour.get(i)+"',")
						.append("debut :'"+horairedebut.get(i)+"',")
						.append("fin :'"+horairefin.get(i)+"'},");
					}
					jsonPointRelais.deleteCharAt(jsonPointRelais.length()-1);
					jsonPointRelais.append("}");
					jsonPointRelais.append("},");
		}
		
		jsonPointRelais.deleteCharAt(jsonPointRelais.length()-1);		
		return jsonPointRelais.toString();
	}
	
	public String jsonConsommateur() {
		StringBuilder jsonConsommateur = new StringBuilder();
		String positionDomicile;
		String positionTravail;
		positionDomicile = "new google.maps.LatLng("+latitudeDomicile+","+longitudeDomicile+")";
		positionTravail = "new google.maps.LatLng("+latitudeTravail+","+longitudeTravail+")";
		
		jsonConsommateur.append("{")
		.append("positionDomicile :" + positionDomicile + ",")
		.append("positionTravail :" + positionTravail + "}");
		
		return jsonConsommateur.toString();
	}
	
	public void recupererTousLesPointRelais() {
		tousLesPointRelais = businessPr.getAllPointRelais();
	}

	public List<PointRelais> getToutpointrelais() {
		return tousLesPointRelais;
	}

	public void setToutpointrelais(List<PointRelais> toutpointrelais) {
		this.tousLesPointRelais = toutpointrelais;
	}

	public IBusinessCommandeChoixPointRelais getBusinessPr() {
		return businessPr;
	}

	public void setBusinessPr(IBusinessCommandeChoixPointRelais businessPr) {
		this.businessPr = businessPr;
	}
	
	
}
