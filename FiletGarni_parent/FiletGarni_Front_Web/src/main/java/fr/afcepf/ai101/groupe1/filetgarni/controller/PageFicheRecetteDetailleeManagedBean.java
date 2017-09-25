package fr.afcepf.ai101.groupe1.filetgarni.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.afcepf.ai101.filetGarni.business.api.IBusinessCommande;
import fr.afcepf.ai101.groupe1.filetGarni.entity.ProduitRecette;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Recette;

@SessionScoped
@ManagedBean(name = "mbFicheRecetteDetaillee")
public class PageFicheRecetteDetailleeManagedBean {
	
	private Recette recetteSelectionnee = new Recette();
	private String tempsPreparation;
	private String tempsCuisson;
	private String descriptifRecette;
	private List<ProduitRecette> produitsRecettesBdd = new ArrayList<>();
	private List<ProduitRecette> produitsRecettesNonBdd = new ArrayList<>();
	
	@EJB
	IBusinessCommande businessCommande;
	
	public String afficherFicheRecetteDetaillee(Integer paramid_recette) {
		recetteSelectionnee = businessCommande.getRecetteByIdWithAllProduitRecette(paramid_recette);
		separationDescriptifRecette(recetteSelectionnee);
		recupererProduitRecetteBdd(recetteSelectionnee);

		for (ProduitRecette produitRecette : produitsRecettesBdd) {
			System.out.println(produitRecette.getCategorie().getLibelle());
		}
		
		return "/commande/ficheRecetteDetaillee/ficheRecetteDetaillee.xhtml?faces-redirect=true";
	}
	
	public void separationDescriptifRecette(Recette paramRecetteSelectionnee) {
		int point = 0;
		
		for (int i = 0; i < paramRecetteSelectionnee.getDescriptif().length(); i++) {
			switch(point) {
			case '0':
				tempsPreparation += paramRecetteSelectionnee.getDescriptif().charAt(i);
				if(paramRecetteSelectionnee.getDescriptif().charAt(i) == '.') {
					point++;
				}
				break;
			case '1':
				tempsCuisson += paramRecetteSelectionnee.getDescriptif().charAt(i);
				if(paramRecetteSelectionnee.getDescriptif().charAt(i) == '.') {
					point++;
				}
				break;
			default:
				descriptifRecette = paramRecetteSelectionnee.getDescriptif()
									.substring(paramRecetteSelectionnee.getDescriptif().charAt(i)
									,paramRecetteSelectionnee.getDescriptif().length());
				return;
			}
		}		
	}
	
	public void recupererProduitRecetteBdd(Recette paramRecetteSelectionnee){
		produitsRecettesBdd.clear();
		produitsRecettesNonBdd.clear();
		List<ProduitRecette> produitsRecette = paramRecetteSelectionnee.getProduitRecettes();
		for (ProduitRecette produitRecette : produitsRecette) {
			if(produitRecette.getCategorie() != null) {
				produitsRecettesBdd.add(produitRecette);
			} else {
				produitsRecettesNonBdd.add(produitRecette);
			}
		}
	}
	
//	GET ET SET
	public Recette getRecetteSelectionnee() {
		return recetteSelectionnee;
	}

	public void setRecetteSelectionnee(Recette paramRecetteSelectionnee) {
		recetteSelectionnee = paramRecetteSelectionnee;
	}

	public IBusinessCommande getBusinessCommande() {
		return businessCommande;
	}

	public void setBusinessCommande(IBusinessCommande paramBusinessCommande) {
		businessCommande = paramBusinessCommande;
	}

	public String getTempsPreparation() {
		return tempsPreparation;
	}

	public void setTempsPreparation(String paramTempsPreparation) {
		tempsPreparation = paramTempsPreparation;
	}

	public String getTempsCuisson() {
		return tempsCuisson;
	}

	public void setTempsCuisson(String paramTempsCuisson) {
		tempsCuisson = paramTempsCuisson;
	}

	public String getDescriptifRecette() {
		return descriptifRecette;
	}

	public void setDescriptifRecette(String paramDescriptifRecette) {
		descriptifRecette = paramDescriptifRecette;
	}
	
	public List<ProduitRecette> getProduitsRecettesBdd() {
		return produitsRecettesBdd;
	}

	public void setProduitsRecettesBdd(List<ProduitRecette> paramProduitsRecettesBdd) {
		produitsRecettesBdd = paramProduitsRecettesBdd;
	}

	public List<ProduitRecette> getProduitsRecettesNonBdd() {
		return produitsRecettesNonBdd;
	}

	public void setProduitsRecettesNonBdd(List<ProduitRecette> paramProduitsRecettesNonBdd) {
		produitsRecettesNonBdd = paramProduitsRecettesNonBdd;
	}	

}
