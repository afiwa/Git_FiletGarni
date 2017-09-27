package fr.afcepf.ai101.groupe1.filetgarni.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import fr.afcepf.ai101.filetGarni.business.api.IBusinessCommande;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Produit;

@SessionScoped
@ManagedBean(name = "mbPageProduitDetaille")
public class PageFicheProduitDetailleManagedBean {
	
	private Produit produitSelectionne = new Produit();
	private String url;
	
	@EJB
	private IBusinessCommande businessCommande;

	public String afficherFicheProduitDetaille(Integer id_produit) {
		url = FacesContext.getCurrentInstance().getViewRoot().getViewId();
		produitSelectionne = businessCommande.getProduitByIdWithConditionnements(id_produit);
		System.out.println(produitSelectionne.getLibelle());
		return "/commande/ficheProduitDetaillee/ficheProduitDetaillee.xhtml?faces-redirect=true";
	}
	
	public String retournerPagePrecedente() {
		return url + "?faces-redirect=true";
	}
	
	public Produit getProduitSelectionne() {
		return produitSelectionne;
	}

	public void setProduitSelectionne(Produit paramProduitSelectionne) {
		produitSelectionne = paramProduitSelectionne;
	}
	
	public IBusinessCommande getBusinessCommande() {
		return businessCommande;
	}

	public void setBusinessCommande(IBusinessCommande paramBusinessCommande) {
		businessCommande = paramBusinessCommande;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String paramUrl) {
		url = paramUrl;
	}
	
}
