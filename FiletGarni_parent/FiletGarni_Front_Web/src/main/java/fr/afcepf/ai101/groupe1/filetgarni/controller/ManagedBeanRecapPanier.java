package fr.afcepf.ai101.groupe1.filetgarni.controller;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import fr.afcepf.ai101.filetGarni.business.api.IBusinessCommande;
import fr.afcepf.ai101.groupe1.filetGarni.entity.LigneCommande;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Produit;

@SessionScoped
@ManagedBean("mbRecapPanier")
public class ManagedBeanRecapPanier implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{mbTestPanier}")
	private ManagedBeanTestPanier monMbTestPanier;

	@EJB
	private IBusinessCommande buCmd;
	private Double totalCommande = 2000d;
	
	public IBusinessCommande getBuCmd() {
		return buCmd;
	}

	public void setBuCmd(IBusinessCommande buCmd) {
		this.buCmd = buCmd;
	}

	public Double getTotalCommande() {
		return totalCommande;
	}

	public void setTotalCommande(Double totalCommande) {
		this.totalCommande = totalCommande;
	}

	public Double getTotalLigneCmde() {
		return totalLigneCmde;
	}

	public void setTotalLigneCmde(Double totalLigneCmde) {
		this.totalLigneCmde = totalLigneCmde;
	}

	public List<Produit> getListePdts() {
		return listePdts;
	}

	public void setListePdts(List<Produit> listePdts) {
		this.listePdts = listePdts;
	}
	private Double totalLigneCmde = 0d;


	//	public augmenterQuantite() {
	//		
	//	}

	public void diminuerQuantite(Integer id) {
		monMbTestPanier.getLigneCommandes().get(id).setQuantiteCommandee(
				monMbTestPanier.getLigneCommandes().get(id).getQuantiteCommandee()-1);
	}
	
	public void augmenterQuantite(Integer id) {
		monMbTestPanier.getLigneCommandes().get(id).setQuantiteCommandee(
				monMbTestPanier.getLigneCommandes().get(id).getQuantiteCommandee()+1);
	}
	//	public supprimerLigneCommande() {
	//		
	//	}
	private List<Produit> listePdts;

	public List<Produit> afficherListeProduitsPanier(){
		return listePdts;
	}

	public void testPanier() {

	}

	
	
	
	// SOURCE A ETUDIER !
	// SOURCE A ETUDIER !
	//  http://adfwebcentermoments.blogspot.fr/2011/05/delete-rows-using-managed-bean-adf.html
	// SOURCE A ETUDIER !
	// SOURCE A ETUDIER !
	public void supprimerLgnCmd(Integer idProduitASupprimer) {
		//		try { 
		//			List malist = Collections.synchronizedList(ligneCommandes);
		//			List malistCopie = new ArrayList();
		//			malistCopie.addAll(maList);
		//			synchronized(malistCopie){ 

		//				ListIterator<LigneCommande> iterator = ligneCommandes.listIterator();
		//				LigneCommande temp;
		//				while(iterator.hasNext()) {
		//					temp = iterator.next();
		//					if((temp.getId().equals(idProduitASupprimer))) {
		//						ligneCommandes.remove(temp);
		//						break;
		//					}
		//				}
		System.out.println("supprimer pdt:"+idProduitASupprimer);
		LigneCommande lgnCmd = new LigneCommande();
		boolean removedStatus = false;

		for (Iterator<LigneCommande> itr= monMbTestPanier.getLigneCommandes().iterator();itr.hasNext();) {
			lgnCmd = (LigneCommande) itr.next();
			if (lgnCmd.getId().equals(idProduitASupprimer)) {
				monMbTestPanier.getLigneCommandes().remove(lgnCmd);
				itr.remove();
				monMbTestPanier.getLigneCommandes().get(0).setQuantiteCommandee(0d);
				removedStatus = true;
				break;
			}
		}
		System.out.println(removedStatus);


		//		List<LigneCommande> ligneCommandesAParcourir = ligneCommandes;
		//		for(LigneCommande lgnCmd : ligneCommandesAParcourir ) {
		//			if((lgnCmd.getProduit().getId() == idProduitASupprimer)) {
		//				ligneCommandes.remove(lgnCmd);
		//				break;
		//			}
		//		}
	}



}
