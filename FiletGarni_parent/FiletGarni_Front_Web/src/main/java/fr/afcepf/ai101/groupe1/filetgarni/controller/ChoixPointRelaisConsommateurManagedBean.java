package fr.afcepf.ai101.groupe1.filetgarni.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.afcepf.ai101.filetGarni.business.api.IBusinessCommandeChoixPointRelais;
import fr.afcepf.ai101.groupe1.filetGarni.entity.HorairesOuverture;
import fr.afcepf.ai101.groupe1.filetGarni.entity.PointRelais;

@SessionScoped
@ManagedBean(name="mbChoixPRConso")
public class ChoixPointRelaisConsommateurManagedBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private List<PointRelais> tousLesPointRelais = new ArrayList<>();
	
	@EJB
	IBusinessCommandeChoixPointRelais businessPr;
	
	@PostConstruct
	public void init() {
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
		List<String> jour = new ArrayList<>();
		List<String> horaire= new ArrayList<>();
		//System.out.println(tousLesPointRelais.size());
		for (PointRelais pr : tousLesPointRelais) {
			longitude = pr.getAdresses().get(0).getLongitude();
			latitude = pr.getAdresses().get(0).getLatitude();
			position = "new google.maps.LatLng("+latitude+","+longitude+")";
			nom = pr.getRaisonSociale();
			ville = pr.getAdresses().get(0).getCodePostal().getVilles().get(0).getNom();
			cp = pr.getAdresses().get(0).getCodePostal().getCodePostal();
			numRue = pr.getAdresses().get(0).getNumeroRue();
			nomRue = pr.getAdresses().get(0).getNomRue();
			for(HorairesOuverture ho :pr.getListeHorairesOuverture()) {
				jour.add(ho.getJour().getLibelle());
				horaire.add(ho.getHeureDeDébut()+" - "+ho.getHeureDeFin());
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
					.append("distance: 0")
					.append("horaires : { ");
					for(int i = 0; i<= jour.size();i++) {
						jsonPointRelais.append("horaire"+i+": {")
						.append("jour:"+jour.get(i)+",horaire :"+horaire.get(i)+"},");
					}
					jsonPointRelais.deleteCharAt(jsonPointRelais.length()-1);
					jsonPointRelais.append("},");
		}
		
		jsonPointRelais.deleteCharAt(jsonPointRelais.length()-1);		
		return jsonPointRelais.toString();
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
