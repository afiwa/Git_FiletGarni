package fr.afcepf.ai101.groupe1.filetgarni.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.afcepf.ai101.filetGarni.business.api.IBusinessCommande;
import fr.afcepf.ai101.groupe1.filetGarni.entity.LigneCommande;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Produit;

@SessionScoped
@ManagedBean(name = "mbTestPanier")
public class ManagedBeanTestPanier implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EJB
	private IBusinessCommande buPdt;
	private Integer idPdt;
	private Integer idPdt2;
	private Integer qte;
	private Integer qte2;
	private Produit pdt;
	
	public String validerPanier() {
		System.out.println("valider Panier");
        HttpSession session = (HttpSession)
                FacesContext.getCurrentInstance()
                .getExternalContext().getSession(true);
        
        session.setAttribute("IdProduit", idPdt);
        System.out.println("produit id :"+ idPdt);
        session.setAttribute("QuantiteProduit", qte);
        System.out.println("qte produit : "+ qte);
        System.out.println("redirection !!!");
        return "/commande/11Panier/panier.xhtml?faces-redirect=true";
	}
	
	public String validerPanierAvecMb() {
		System.out.println("valider Panier AVEC MB");
		pdt = buPdt.getProduitById(idPdt);
		
//		lgnCmd = new LigneCommande(null, qte, null, null, null, null, null, );
		
        return "/commande/11Panier/panier.xhtml?faces-redirect=true";
	}


	public IBusinessCommande getBuPdt() {
		return buPdt;
	}

	public void setBuPdt(IBusinessCommande buPdt) {
		this.buPdt = buPdt;
	}


	public Integer getIdPdt() {
		return idPdt;
	}

	public void setIdPdt(Integer idPdt) {
		this.idPdt = idPdt;
	}

	public Integer getQte() {
		return qte;
	}

	public void setQte(Integer qte) {
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

	public Integer getQte2() {
		return qte2;
	}

	public void setQte2(Integer qte2) {
		this.qte2 = qte2;
	}

	public Produit getPdt() {
		return pdt;
	}

	public void setPdt(Produit pdt) {
		this.pdt = pdt;
	}
	
}
