package fr.afcepf.ai101.groupe1.filetgarni.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.afcepf.ai101.filetGarni.business.api.IBusinessCommande;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Produit;

@SessionScoped
@ManagedBean(name="mbProducteurGestionCatalogue")
public class ProducteurGestioncatalogueManagedBean {
	
	private Produit produitSelectionne = new Produit();
	
	@EJB
	IBusinessCommande businessCommande;
	public String afficherProduitSelectionne(Integer id_produit) {
		produitSelectionne = businessCommande.getProduitByIdWithConditionnements(id_produit);
		return "/producteur/catalogueProducteur/ficheDetailleeCatalogueLaVraie.xhtml?faces-redirect=true";
		
	}
	
	public Produit getProduitSelectionne() {
		return produitSelectionne;
	}
	public void setProduitSelectionne(Produit produitSelectionne) {
		this.produitSelectionne = produitSelectionne;
	}
	public IBusinessCommande getBusinessCommande() {
		return businessCommande;
	}
	public void setBusinessCommande(IBusinessCommande businessCommande) {
		this.businessCommande = businessCommande;
	}
	
	

}
