package fr.afcepf.ai101.groupe1.filetgarni.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.afcepf.ai101.filetGarni.business.api.IBusinessCommande;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Produit;

@SessionScoped
@ManagedBean(name = "mbPageAccueilConso")
public class pageAccueilConsoManagedBean {

	@EJB
	IBusinessCommande businessCommande;
	
	public Produit afficherProduit(Integer id_produit) {
		return businessCommande.getProduitByIdWithConditionnements(id_produit);
	}
}
