package fr.afcepf.ai101.groupe1.filetgarni.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
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
	private Produit pdt  = new Produit();
	private Produit pdt2 = new Produit();
	private List<LigneCommande> ligneCommandes= new ArrayList<LigneCommande>();
	private Double totalMontantCommande;
	

	public String testRemplirAfficherPanier() {
		pdt = buPdt.getProduitByIdWithConditionnements(idPdt);
		pdt2 = buPdt.getProduitByIdWithConditionnements(idPdt2);
		LigneCommande lgn1 = new LigneCommande(null, qte, null, null, null, null, null, pdt, null, null);
		LigneCommande lgn2 = new LigneCommande(null, qte2, null, null, null, null, null, pdt2, null, null);
		ligneCommandes.add(lgn1);
		ligneCommandes.add(lgn2);
		calculTotalMontantCommande();

		return "/commande/11Panier/panier.xhtml?faces-redirect=true";
	}
	
	public void modifierQuantite(LigneCommande lgnCommandeTemp, Integer chiffreModificateur, Integer qteCommandee) {
		System.out.println("Fonction diminuer quantite ligne commande.");
		if(chiffreModificateur == -1 && qteCommandee == 1) {
		} else {
			for(LigneCommande lgnCmd : ligneCommandes ) {
				if(lgnCmd.getProduit().getId().equals(lgnCommandeTemp.getProduit().getId())) {
					lgnCmd.setQuantiteCommandee(lgnCmd.getQuantiteCommandee()+(chiffreModificateur));
					calculTotalMontantCommande();
				}
			}
		}
	}

	public String supprimerLgnCmd(LigneCommande ligneCommandeTempASupprimer) {
		System.out.println("test");
		ligneCommandes.remove(ligneCommandeTempASupprimer);
		calculTotalMontantCommande();
		return "/commande/11Panier/panier.xhtml?faces-redirect=true";
	}


	public IBusinessCommandeMarion getBuPdt() {
		return buPdt;
	}

	public void setBuPdt(IBusinessCommandeMarion paramBuPdt) {
		buPdt = paramBuPdt;
	}

	public Integer getIdPdt() {
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

	public static long getSerialversionuid() {
		return serialVersionUID;
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

	public void setPdt(Produit pdt) {
		this.pdt = pdt;
	}


	public Produit getPdt2() {
		return pdt2;
	}


	public void setPdt2(Produit pdt2) {
		this.pdt2 = pdt2;
	}


	public List<LigneCommande> getLigneCommandes() {
		return ligneCommandes;
	}


	public void setLigneCommandes(List<LigneCommande> ligneCommandes) {
		this.ligneCommandes = ligneCommandes;
	}
	
	public Double getTotalMontantCommande() {
		return totalMontantCommande;
	}


	public void setTotalMontantCommande(Double totalMontantCommande) {
		this.totalMontantCommande = totalMontantCommande;
	}


	public void calculTotalMontantCommande() {
		totalMontantCommande = 0d;
		for(LigneCommande lgnCmd : ligneCommandes) {
			totalMontantCommande = totalMontantCommande + lgnCmd.getMontantLgnCommande(lgnCmd.getProduit().getPrix());
		}
	}
	

}