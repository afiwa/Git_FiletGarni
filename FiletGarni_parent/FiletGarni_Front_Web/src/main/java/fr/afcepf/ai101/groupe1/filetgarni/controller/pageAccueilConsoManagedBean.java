package fr.afcepf.ai101.groupe1.filetgarni.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.afcepf.ai101.filetGarni.business.api.IBusinessCommande;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Producteur;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Produit;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Recette;

@SessionScoped
@ManagedBean(name = "mbPageAccueilConso")
public class pageAccueilConsoManagedBean {
	private List<Producteur> tousLesProducteurs = new ArrayList<>();
	
	@EJB
	IBusinessCommande businessCommande;
	
	@PostConstruct
	public void init() {
		recupererTousLesProducteurs();
	}
	public String jsonProducteur() {
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
		
		for (Producteur producteur : tousLesProducteurs) {
			longitude = producteur.getAdresses().get(0).getLongitude();
			latitude = producteur.getAdresses().get(0).getLatitude();
			position = "new google.maps.LatLng("+latitude+","+longitude+")";
			nom = producteur.getNom();
			prenom = producteur.getPrenom();
			photo = producteur.getPhoto();
//			ville = producteur.getAdresses().get(0).getCodePostal().getVilles().get(0).getNom();
//			cp = producteur.getAdresses().get(0).getCodePostal().getCodePostal();
			numRue = producteur.getAdresses().get(0).getNumeroRue();
			nomRue = producteur.getAdresses().get(0).getNomRue();
			if(numRue != null) {
				adresse = numRue + " " + nomRue;
			}
			else {
				adresse = nomRue;
			}
//			categorie = producteur.getCategories().get(0).getLibelle();	
			jsonProducteurs += "{"
					+"position:'" + position + "',"
					+"nom:'" + nom + "',"
					+"prenom:'" + prenom + "',"
					+"adresse:'" + adresse + "',"
//					+"ville:" + ville + ","
//					+"cp:" + cp + ","
//					+"categorie:" + categorie + ","
					+"photo:'" + photo+"'"
					+"},"; 
		}
		
		jsonProducteurs = jsonProducteurs.substring(0, jsonProducteurs.length() - 1);		
		return jsonProducteurs;
	}
	public Produit afficherProduit(Integer id_produit) {
		return businessCommande.getProduitByIdWithConditionnements(id_produit);
	}
	
	public Recette afficherRecette(Integer id_recette) {
		return businessCommande.getRecetteByIdWithAllProduitRecette(id_recette);
	}
	
	public void recupererTousLesProducteurs() {
		tousLesProducteurs = businessCommande.getAllProducteurs();
	}

	public List<Producteur> getTousLesProducteurs() {
		return tousLesProducteurs;
	}

	public void setTousLesProducteurs(List<Producteur> paramTousLesProducteurs) {
		tousLesProducteurs = paramTousLesProducteurs;
	}

	public IBusinessCommande getBusinessCommande() {
		return businessCommande;
	}

	public void setBusinessCommande(IBusinessCommande paramBusinessCommande) {
		businessCommande = paramBusinessCommande;
	}
	
}
