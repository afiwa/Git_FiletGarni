package fr.afcepf.ai101.groupe1.filetgarni.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
	private Integer idPdt;
	private Integer idPdt2;
	private Double qte;
	private Double qte2;
	private Double quantite = 0d;
	private Integer idProduit;
	private Produit pdt = new Produit();
	private List<LigneCommande> ligneCommandes= new ArrayList<LigneCommande>();
	private Double totalMontantCommande;
	

	public void remplirPanier(Integer chiffreModificateur, Produit produit) {
		if (!isInLigneCommandes(produit) && chiffreModificateur==1){
			LigneCommande ligneCommande = new LigneCommande(null, 1d, produit);
			ligneCommandes.add(ligneCommande);
			System.out.println(ligneCommande.toString());
		} 
		else if(isInLigneCommandes(produit)) {
			if((getLigneCommandeWithProduit(produit).getQuantiteCommandee() == 1 && chiffreModificateur==-1)) {
				ligneCommandes.remove(getLigneCommandeWithProduit(produit));
			}
			else {
				getLigneCommandeWithProduit(produit).setQuantiteCommandee(modifierQuantitePanier(
																			getLigneCommandeWithProduit(produit)
																			, chiffreModificateur));
				System.out.println(getLigneCommandeWithProduit(produit).toString());
			}
		}
		
		//		pdt = buPdt.getProduitByIdWithConditionnements(idPdt);
		//		pdt2 = buPdt.getProduitByIdWithConditionnements(idPdt2);
		//		LigneCommande lgn1 = new LigneCommande(null, qte, null, null, null, null, null, pdt, null, null);
		//		LigneCommande lgn2 = new LigneCommande(null, qte2, null, null, null, null, null, pdt2, null, null);
		//		ligneCommandes.add(lgn1);
		//		ligneCommandes.add(lgn2);
		calculTotalMontantCommande();

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

	public Double modifierQuantitePanier(LigneCommande lgnCommandeTemp, Integer chiffreModificateur) {
		Double qteCommandee = lgnCommandeTemp.getQuantiteCommandee();
		if(chiffreModificateur == -1 && qteCommandee == 0d) {
		} else {
			for(LigneCommande lgnCmd : ligneCommandes ) {
				if(lgnCmd.getProduit().getId().equals(lgnCommandeTemp.getProduit().getId()) && 
						lgnCmd.getQuantiteCommandee()<buPdt.getQuantiteEnStock(lgnCommandeTemp.getProduit().getId())) {
					lgnCmd.setQuantiteCommandee(lgnCmd.getQuantiteCommandee()+(chiffreModificateur));
					calculTotalMontantCommande();
					return lgnCmd.getQuantiteCommandee();
				}
			}
		}
		return lgnCommandeTemp.getQuantiteCommandee();
	}

	public String supprimerLgnCmd(LigneCommande ligneCommandeTempASupprimer) {
		System.out.println("test");
		ligneCommandes.remove(ligneCommandeTempASupprimer);
		calculTotalMontantCommande();
		return "/commande/11Panier/panier.xhtml?faces-redirect=true";
	}

	public void calculTotalMontantCommande() {
		totalMontantCommande = 0d;
		for(LigneCommande lgnCmd : ligneCommandes) {
			totalMontantCommande = totalMontantCommande + lgnCmd.getMontantLgnCommande(lgnCmd.getProduit().getPrix());
		}
		System.out.println(totalMontantCommande);
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

	public Double getTotalMontantCommande() {
		return totalMontantCommande;
	}
	
	public List<LigneCommande> getLigneCommandes() {
		return ligneCommandes;
	}

	public void setLigneCommandes(List<LigneCommande> ligneCommandes) {
		this.ligneCommandes = ligneCommandes;
	}

/*	public Integer getIdPdt() {
=======

	public void setTotalMontantCommande(Double totalMontantCommande) {
		this.totalMontantCommande = totalMontantCommande;
	}
	
	public Integer getIdPdt() {
>>>>>>> Marion
		return idPdt;
	}

	public void setIdPdt(Integer idPdt) {
		this.idPdt = idPdt;
	}

	public Double getQte() {
		return qte;
	}

	public void setQte(Double qte) {
		this.qte = qte;
	}

	public Integer getIdPdt2() {
		return idPdt2;
	}

	public void setIdPdt2(Integer idPdt2) {
		this.idPdt2 = idPdt2;
	}

	public Double getQte2() {
		return qte2;
	}

	public void setQte2(Double qte2) {
		this.qte2 = qte2;
	}

	public Produit getPdt() {
		return pdt;
	}

	public void setPdt(Produit paramPdt) {
		pdt = paramPdt;
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

	public Integer getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(Integer paramIdProduit) {
		idProduit = paramIdProduit;
	}

	public void setQuantite(Double paramQuantite) {
		quantite = paramQuantite;
	}

	public List<LigneCommande> getLigneCommandes() {
		return ligneCommandes;
	}

	public void setLigneCommandes(List<LigneCommande> ligneCommandes) {
		this.ligneCommandes = ligneCommandes;
	}
<<<<<<< HEAD
	
	public Double getTotalMontantCommande() {
		return totalMontantCommande;
	}


	public void setTotalMontantCommande(Double totalMontantCommande) {
		this.totalMontantCommande = totalMontantCommande;
	} */

}