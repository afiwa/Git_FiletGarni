package fr.afcepf.ai101.groupe1.filetgarni.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.afcepf.ai101.filetGarni.business.api.IBusinessCommande;
import fr.afcepf.ai101.groupe1.filetGarni.entity.LigneCommande;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Produit;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Recette;

@SessionScoped
@ManagedBean(name = "mbPageAccueilConso")
public class pageAccueilConsoManagedBean {

	@EJB
	LigneCommande ligneCommande;
	
	@EJB
	IBusinessCommande businessCommande;
	
	public Produit afficherProduit(Integer id_produit) {
		return businessCommande.getProduitByIdWithConditionnements(id_produit);
	}
	
	public Recette afficherRecette(Integer id_recette) {
		return businessCommande.getRecetteByIdWithAllProduitRecette(id_recette);
	}
}
