package fr.afcepf.ai101.groupe1.filetgarni.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.afcepf.ai101.filetGarni.business.api.IBusinessCommande;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Produit;

@SessionScoped
@ManagedBean(name = "mbPageProduitDetaille")
public class PageFicheProduitDetailleManagedBean {
	
	private Produit produitSelectionne = new Produit();
	
	@EJB
	IBusinessCommande businessCommande;

	public String afficherFicheProduitDetaille(Integer id_produit) {
		produitSelectionne = businessCommande.getProduitByIdWithConditionnements(id_produit);
		System.out.println(produitSelectionne.getLibelle());
		return "/commande/ficheProduitDetaillee/ficheProduitDetaillee.xhtml?faces-redirect=true";
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
	
}
