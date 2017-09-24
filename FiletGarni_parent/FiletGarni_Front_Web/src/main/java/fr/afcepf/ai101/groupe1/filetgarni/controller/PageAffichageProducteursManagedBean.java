package fr.afcepf.ai101.groupe1.filetgarni.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
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
	
	public String afficherProducteursParCategorie(Integer id_categorie) {
		producteursParCategorie = businnesCommande.getProducteurbyIdCategorie(id_categorie);
		return "/commande/fichesProducteurs/pageAffichageProducteursParCategorie.xhtml?faces-redirect=true";
	}
	
	public String jsonProducteursParCategorie() {
		String jsonProducteurs = "";
		String longitude;
		String latitude;
		String position;
		String nom;
		String prenom;
		String adresse;
		String numRue;
		String nomRue;
		String ville;
		String cp;
		String photo;
		String categorie;
		
		for (Producteur producteur : producteursParCategorie) {
			longitude = producteur.getAdresses().get(0).getLongitude();
			latitude = producteur.getAdresses().get(0).getLatitude();
			position = "new google.maps.LatLng("+latitude+","+longitude+")";
			nom = producteur.getNom();
			prenom = producteur.getPrenom();
			photo = producteur.getPhoto();
			ville = producteur.getAdresses().get(0).getCodePostal().getVilles().get(0).getNom();
			cp = producteur.getAdresses().get(0).getCodePostal().getCodePostal();
			numRue = producteur.getAdresses().get(0).getNumeroRue();
			nomRue = producteur.getAdresses().get(0).getNomRue();
			if(numRue != null) {
				adresse = numRue + " " + nomRue;
			}
			else {
				adresse = nomRue;
			}
			categorie = producteur.getCategories().get(0).getLibelle();	
			jsonProducteurs += "{"
					+"position:" + position + ","
					+"nom:\"" + nom + "\","
					+"prenom:'" + prenom + "',"
					+"adresse:\"" + adresse + "\","
					+"ville:\"" + ville + "\","
					+"cp:'" + cp + "',"
					+"categorie:\"" + categorie + "\","
					+"photo:'" + photo+"'"
					+"},"; 
		}
		
		jsonProducteurs = jsonProducteurs.substring(0, jsonProducteurs.length() - 1);		
		return jsonProducteurs;
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
