package fr.afcepf.ai101.groupe1.filetgarni.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import fr.afcepf.ai101.filetGarni.business.api.IBusinessCommande;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Producteur;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Produit;

@SessionScoped
@ManagedBean(name ="mbFicheProducteurDetaille")
public class PageFicheProducteurDetailleManagedBean {
	private Producteur producteurSelectionne = new Producteur();
	private List<Produit> produitsProducteur = new ArrayList<>();
	private String url;
	
	@EJB
	private IBusinessCommande businessCommande;	

	public String afficherFicheProducteurDetaille(Integer paramid_producteur) {
		url = FacesContext.getCurrentInstance().getViewRoot().getViewId();
		producteurSelectionne = businessCommande.getProducteurById(paramid_producteur);
		produitsProducteur = businessCommande.getProduitsByIdProducteur(paramid_producteur);
		return "/commande/ficheProducteurDetaillee/ficheProducteurDetaillee.xhtml?faces-redirect=true";
	}
	
	public String afficherFicheProducteurDetailleParIdProduit(Integer paramid_produit) {
		url = FacesContext.getCurrentInstance().getViewRoot().getViewId();
		producteurSelectionne = businessCommande.getProducteurByIdProduit(paramid_produit);
		produitsProducteur = businessCommande.getProduitsByIdProducteur(producteurSelectionne.getId());
		return "/commande/ficheProducteurDetaillee/ficheProducteurDetaillee.xhtml?faces-redirect=true";
	}
	
	public String retournerPagePrecedente() {
		return url + "?faces-redirect=true";
	}
	
//	GET ET SET

	public IBusinessCommande getBusinessCommande() {
		return businessCommande;
	}

	public Producteur getProducteurSelectionne() {
		return producteurSelectionne;
	}

	public void setProducteurSelectionne(Producteur paramProducteurSelectionne) {
		producteurSelectionne = paramProducteurSelectionne;
	}

	public void setBusinessCommande(IBusinessCommande paramBusinessCommande) {
		businessCommande = paramBusinessCommande;
	}

	public List<Produit> getProduitsProducteur() {
		return produitsProducteur;
	}

	public void setProduitsProducteur(List<Produit> paramProduitsProducteur) {
		produitsProducteur = paramProduitsProducteur;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String paramUrl) {
		url = paramUrl;
	}		
}
