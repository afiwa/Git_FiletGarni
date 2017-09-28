package fr.afcepf.ai101.groupe1.filetgarni.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import fr.afcepf.ai101.filetGarni.business.api.IBusinessCommande;
import fr.afcepf.ai101.filetGarni.business.api.IBusinessCommandeMarion;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Produit;

@SessionScoped
@ManagedBean(name = "mbPageProduitDetaille")
public class PageFicheProduitDetailleManagedBean {
	
	private Produit produitSelectionne = new Produit();
	private String url;
	private Integer quantiteCommandable = 0;
	private List<Integer> quantitesEnStockCommandables = new ArrayList<>();
	private Map<Integer, List<Integer>> quantitesEnStock = new HashMap<>();
	
	
	@EJB
	private IBusinessCommande businessCommande;
	@EJB
	private IBusinessCommandeMarion buCmdeMarion;
	

	public String afficherFicheProduitDetaille(Integer id_produit) {
		url = FacesContext.getCurrentInstance().getViewRoot().getViewId();
		produitSelectionne = businessCommande.getProduitByIdWithConditionnements(id_produit);
		for (int i = 0; i < buCmdeMarion.getQuantiteEnStock(id_produit) ; i++) {
			quantiteCommandable+=1;
			quantitesEnStockCommandables.add(quantiteCommandable);
		}
		quantitesEnStock.put(id_produit, quantitesEnStockCommandables);
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

	public Integer getQuantiteCommandable() {
		return quantiteCommandable;
	}

	public void setQuantiteCommandable(Integer paramQuantiteCommandable) {
		quantiteCommandable = paramQuantiteCommandable;
	}

	public List<Integer> getQuantitesEnStockCommandables() {
		return quantitesEnStockCommandables;
	}

	public void setQuantitesEnStockCommandables(List<Integer> paramQuantitesEnStockCommandables) {
		quantitesEnStockCommandables = paramQuantitesEnStockCommandables;
	}

	public Map<Integer, List<Integer>> getQuantitesEnStock() {
		return quantitesEnStock;
	}

	public void setQuantitesEnStock(Map<Integer, List<Integer>> paramQuantitesEnStock) {
		quantitesEnStock = paramQuantitesEnStock;
	}

	public IBusinessCommandeMarion getBuCmdeMarion() {
		return buCmdeMarion;
	}

	public void setBuCmdeMarion(IBusinessCommandeMarion paramBuCmdeMarion) {
		buCmdeMarion = paramBuCmdeMarion;
	}

	

	
	
	
	
}
