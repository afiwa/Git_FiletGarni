package fr.afcepf.ai101.groupe1.filetgarni.controller;

import java.io.Console;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.afcepf.ai101.filetGarni.business.api.IBusinessCommande;
import fr.afcepf.ai101.filetGarni.business.api.IBusinessCommandeMarion;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Commande;
import fr.afcepf.ai101.groupe1.filetGarni.entity.LigneCommande;

@SessionScoped
@ManagedBean(name="mbPaiement")
public class ManagedBeanPaiement implements Serializable {


	private static final long serialVersionUID = 1L;

	@ManagedProperty(value="#{mbTestPanier}")
	private ManagedBeanTestPanier monMbTestPanier;
	
	@ManagedProperty(value="#{mbConnecterConso}")
	private ManagedBeanConnexionConsommateur monMbCnxConso;

	@EJB
	private IBusinessCommandeMarion buCmde;
	private IBusinessCommande buCmde2;

	private Commande commande = new Commande();
	private Integer id_paiement = 1;
	private Integer id_pointRelais = 1;

<<<<<<< HEAD
	/*public String validerCommande() {
		Integer idNouvelleCommande = buCmde.creerUneCommande(null, new Date(), new Date(), new Date(), buCmde.getTypePaiementById(id_paiement),buCmde.getPRById(id_pointRelais), buCmde.getConsoById(monMbCnxConso.getConsommateurConnecte().getId()));
		for(LigneCommande l : monMbTestPanier.getLigneCommandes()) {
			buCmde.creerUneLigneCommande(null, l.getQuantiteCommandee(), buCmde.getCommandebyId(idNouvelleCommande), l.getProduit());
		}
		return "/commande/14RecapitulatifCommande/recapitulatifCommande.xhtml";
	}*/
=======
	public String validerCommande() {
		System.out.println("je valide ma commande");
		Integer idNouvelleCommande = buCmde.creerUneCommande(null, new Date(), new Date(), new Date(), buCmde.getTypePaiementById(id_paiement), buCmde.getPRById(id_pointRelais), buCmde.getConsoById(monMbCnxConso.getConsommateurConnecte().getId()));
		System.out.println("##### id cmd : "+idNouvelleCommande);
		for(LigneCommande l : monMbTestPanier.getLigneCommandes()) {
			buCmde.creerUneLigneCommande(null, l.getQuantiteCommandee(), buCmde.getCommandebyId(idNouvelleCommande), l.getProduit());
		}
		System.out.println("##### id cmd : "+idNouvelleCommande);

		// Dans l'idéal, il faudrait aller récupérer 
		
		commande = buCmde.getCommandebyId(idNouvelleCommande);
		List<LigneCommande> listTemp = new ArrayList<LigneCommande>();
		for(LigneCommande lgnCmd : monMbTestPanier.getLigneCommandes()) {
			listTemp.add(lgnCmd);
		}
		commande.setLgnCommandes(listTemp);

//		System.out.println("montant cmd : "+commande.getMontantCommande());

//		commande.setLgnCommandes(buCmde2.getCommandebyId(idNouvelleCommande).getLgnCommandes());
//		System.out.println("##### id cmd : "+idNouvelleCommande);

		return "/commande/14RecapitulatifCommande/recapitulatifCommande.xhtml?faces-redirect=true";
	}
>>>>>>> Ludo-mardi

	public Date calculDateLivraison() {
		Date dateLivraison= new Date();
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(new Date());
		int today = cal.get(Calendar.DAY_OF_WEEK);
		switch (today) {
		case GregorianCalendar.THURSDAY:
			cal.add(cal.DATE, 4);			
			break;

		default:
			cal.add(cal.DATE, 3);
			break;
		}
		//Calendar cal = Calendar.getInstance(Locale.FRANCE);
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-JJ hh:mm:ss", Locale.FRANCE);		
		dateLivraison = cal.getTime();
		return dateLivraison;
	}

	public ManagedBeanTestPanier getMonMbTestPanier() {
		return monMbTestPanier;
	}

	public void setMonMbTestPanier(ManagedBeanTestPanier paramMonMbTestPanier) {
		monMbTestPanier = paramMonMbTestPanier;
	}

	public ManagedBeanConnexionConsommateur getMonMbCnxConso() {
		return monMbCnxConso;
	}

	public void setMonMbCnxConso(ManagedBeanConnexionConsommateur paramMonMbCnxConso) {
		monMbCnxConso = paramMonMbCnxConso;
	}

	public IBusinessCommandeMarion getBuCmde() {
		return buCmde;
	}

	public void setBuCmde(IBusinessCommandeMarion paramBuCmde) {
		buCmde = paramBuCmde;
	}

	public Integer getId_paiement() {
		return id_paiement;
	}

	public void setId_paiement(Integer paramId_paiement) {
		id_paiement = paramId_paiement;
	}

	public Integer getId_pointRelais() {
		return id_pointRelais;
	}

	public void setId_pointRelais(Integer paramId_pointRelais) {
		id_pointRelais = paramId_pointRelais;
	}
	
	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}


}
