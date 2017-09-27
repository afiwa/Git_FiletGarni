package fr.afcepf.ai101.groupe1.filetgarni.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.afcepf.ai101.filetGarni.business.api.IBusinessCommandeMarion;
import fr.afcepf.ai101.groupe1.filetGarni.entity.LigneCommande;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Produit;

@SessionScoped
@ManagedBean(name = "mbTestPanier")
public class ManagedBeanTestPanier implements Serializable{

	private static final long serialVersionUID = 1L;

	@EJB
	private IBusinessCommandeMarion buPdt;
	private Double quantite = 0d;
	private Integer idProduit;
	private Produit pdt = new Produit();
	private List<LigneCommande> ligneCommandes= new ArrayList<LigneCommande>();
	private Double totalMontantCommande;
	private Map<Integer, Integer> quantites = new HashMap<>();
	private Double quantiteTotalePanier = 0d;
	private Double quantiteSelectionnee;

	public void remplirPanier(Integer chiffreModificateur, Produit produit) {
		if (!isInLigneCommandes(produit) && chiffreModificateur==1){
			LigneCommande ligneCommande = new LigneCommande(null, 1d, produit);
			quantites.put(produit.getId(), 1);
			ligneCommandes.add(ligneCommande);
			System.out.println(ligneCommande.toString());
		} 
		else if(isInLigneCommandes(produit)) {
			if((getLigneCommandeWithProduit(produit).getQuantiteCommandee() == 1 && chiffreModificateur==-1)) {
				ligneCommandes.remove(getLigneCommandeWithProduit(produit));
				quantites.remove(produit.getId());
			}
			else {
				getLigneCommandeWithProduit(produit).setQuantiteCommandee(modifierQuantitePanier(
																			getLigneCommandeWithProduit(produit)
																			, chiffreModificateur));
				
				System.out.println(getLigneCommandeWithProduit(produit).toString());
			}
		}
	calculTotalMontantCommande();
	calculQuantiteTotalPanier();
	}
	
	
	public String validerPanier() {
		return "/commande/11Panier/panier.xhtml?faces-redirect=true";
	}

	public void modifierQuantite(LigneCommande lgnCommandeTemp, Integer chiffreModificateur, Double qteCommandee) {
		if(chiffreModificateur == -1 && qteCommandee == 1d || 
				(qteCommandee >= buPdt.getQuantiteEnStock(lgnCommandeTemp.getProduit().getId()) && chiffreModificateur == 1d )) {			
		} else { 
			for(LigneCommande lgnCmd : ligneCommandes ) { 
				if(lgnCmd.getProduit().getId().equals(lgnCommandeTemp.getProduit().getId()) ) {
					lgnCmd.setQuantiteCommandee(lgnCmd.getQuantiteCommandee()+(chiffreModificateur));
					calculTotalMontantCommande();
				}
			} 
		} 
	}
	public void modifierLgnCmd(LigneCommande lc) {
		for (LigneCommande ligneCommande : ligneCommandes) {
			if(lc.getId() == ligneCommande.getId()) {
				quantites.put(ligneCommande.getProduit().getId(), lc.getQuantiteCommandee().intValue());
			}
		}
		calculTotalMontantCommande();
		calculQuantiteTotalPanier();
	}
	
	public void remplirPanierByList(Produit produit, Double quantiteSelectionnee) {
		if (!isInLigneCommandes(produit)){
			LigneCommande ligneCommande = new LigneCommande(null, 1d, produit);
			quantites.put(produit.getId(), 1);
			ligneCommandes.add(ligneCommande);
		} else {
			getLigneCommandeWithProduit(produit).setQuantiteCommandee(quantiteSelectionnee);
		}
		
	}
	
	
	public Double modifierQuantitePanier(LigneCommande lgnCommandeTemp, Integer chiffreModificateur) {
		Double qteCommandee = lgnCommandeTemp.getQuantiteCommandee();
		if(chiffreModificateur == -1 && qteCommandee == 0d) {
		} else {
			for(LigneCommande lgnCmd : ligneCommandes ) {
				if(lgnCmd.getProduit().getId().equals(lgnCommandeTemp.getProduit().getId()) && 
						lgnCmd.getQuantiteCommandee()<buPdt.getQuantiteEnStock(lgnCommandeTemp.getProduit().getId())) {
					
					quantites.put(lgnCommandeTemp.getProduit().getId(), quantites.get(lgnCommandeTemp.getProduit().getId()) + chiffreModificateur);
					lgnCmd.setQuantiteCommandee(lgnCmd.getQuantiteCommandee()+(chiffreModificateur));
					calculTotalMontantCommande();
					calculQuantiteTotalPanier();
					return lgnCmd.getQuantiteCommandee();
				}
			}
		}
		return lgnCommandeTemp.getQuantiteCommandee();
	}

	public void supprimerLgnCmd(LigneCommande ligneCommandeTempASupprimer) {
		System.out.println("test");
		ligneCommandes.remove(ligneCommandeTempASupprimer);
		quantites.remove(ligneCommandeTempASupprimer.getProduit().getId());
		calculTotalMontantCommande();
		calculQuantiteTotalPanier();
		
	}

	public void calculTotalMontantCommande() {
		totalMontantCommande = 0d;
		for(LigneCommande lgnCmd : ligneCommandes) {
			totalMontantCommande = totalMontantCommande + lgnCmd.getMontantLgnCommande(lgnCmd.getProduit().getPrix());
		}
		System.out.println(totalMontantCommande);
	}
	

	
	
	public void calculQuantiteTotalPanier() {
		for (LigneCommande ligneCommande : ligneCommandes) {
			quantiteTotalePanier = quantiteTotalePanier + ligneCommande.getQuantiteCommandee();
		}
	}
	
	public Double afficherQuantiteLigneCommande(Produit produit) {
		for(LigneCommande l : ligneCommandes) {
			if(produit.equals(l.getProduit())) {
				return l.getQuantiteCommandee();
			}
		}
		return 0d;
	}
	
	public Boolean isInLigneCommandes(Produit produit) {
		for(LigneCommande l : ligneCommandes) {
			if(produit.equals(l.getProduit())) {
				return true;
			}
		}
		return false;
	}
	
	public LigneCommande getLigneCommandeWithProduit(Produit produit) {
		for(LigneCommande l : ligneCommandes) {
			if(produit.equals(l.getProduit())) {
				return l;
			}
		}
		return null;
	}
	

	public IBusinessCommandeMarion getBuPdt() {
		return buPdt;
	}

	public void setBuPdt(IBusinessCommandeMarion paramBuPdt) {
		buPdt = paramBuPdt;
	}

	public Double getQuantite() {
		return quantite;
	}

	public void setQuantite(Double paramQuantite) {
		quantite = paramQuantite;
	}

	public Integer getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(Integer paramIdProduit) {
		idProduit = paramIdProduit;
	}

	public Produit getPdt() {
		return pdt;
	}

	public void setPdt(Produit paramPdt) {
		pdt = paramPdt;
	}

	public List<LigneCommande> getLigneCommandes() {
		return ligneCommandes;
	}

	public void setLigneCommandes(List<LigneCommande> paramLigneCommandes) {
		ligneCommandes = paramLigneCommandes;
	}

	public Double getTotalMontantCommande() {
		return totalMontantCommande;
	}

	public void setTotalMontantCommande(Double paramTotalMontantCommande) {
		totalMontantCommande = paramTotalMontantCommande;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Map<Integer, Integer> getQuantites() {
		return quantites;
	}

	public void setQuantites(Map<Integer, Integer> paramQuantites) {
		quantites = paramQuantites;
	}

	public Double getQuantiteTotalePanier() {
		return quantiteTotalePanier;
	}

	public void setQuantiteTotalePanier(Double paramQuantiteTotalePanier) {
		quantiteTotalePanier = paramQuantiteTotalePanier;
	}


	
	

	
}