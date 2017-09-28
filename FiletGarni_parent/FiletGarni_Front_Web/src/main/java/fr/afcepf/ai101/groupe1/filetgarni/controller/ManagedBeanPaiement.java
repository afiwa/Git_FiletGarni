package fr.afcepf.ai101.groupe1.filetgarni.controller;

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

import fr.afcepf.ai101.filetGarni.business.api.IBusinessCommandeMarion;
import fr.afcepf.ai101.groupe1.filetGarni.entity.CodePostal;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Commande;
import fr.afcepf.ai101.groupe1.filetGarni.entity.LigneCommande;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Ville;

@SessionScoped
@ManagedBean(name="mbPaiement")
public class ManagedBeanPaiement implements Serializable {


	private static final long serialVersionUID = 1L;

	@ManagedProperty(value="#{mbTestPanier}")
	private ManagedBeanTestPanier monMbTestPanier;
	
	@ManagedProperty(value="#{mbConnecterConso}")
	private ManagedBeanConnexionConsommateur monMbCnxConso;

	@ManagedProperty(value="#{mbChoixPRConso}")
	private ChoixPointRelaisConsommateurManagedBean monMbChoixPRConso;
	
	@EJB
	private IBusinessCommandeMarion buCmde;

	private Commande commande = new Commande();
	private Integer id_paiement = 1;
	private Integer id_pointRelais = 1;

	/*public String validerCommande() {
		Integer idNouvelleCommande = buCmde.creerUneCommande(null, new Date(), new Date(), new Date(), buCmde.getTypePaiementById(id_paiement),buCmde.getPRById(id_pointRelais), buCmde.getConsoById(monMbCnxConso.getConsommateurConnecte().getId()));
		for(LigneCommande l : monMbTestPanier.getLigneCommandes()) {
			buCmde.creerUneLigneCommande(null, l.getQuantiteCommandee(), buCmde.getCommandebyId(idNouvelleCommande), l.getProduit());
		}
		return "/commande/14RecapitulatifCommande/recapitulatifCommande.xhtml";
	}*/

	public ChoixPointRelaisConsommateurManagedBean getMonMbChoixPRConso() {
		return monMbChoixPRConso;
	}

	public void setMonMbChoixPRConso(ChoixPointRelaisConsommateurManagedBean monMbChoixPRConso) {
		this.monMbChoixPRConso = monMbChoixPRConso;
	}

	public String validerCommande() {
		System.out.println("je valide ma commande");
		Integer idNouvelleCommande = buCmde.creerUneCommande(null, new Date(), new Date(), calculDateLivraison(), buCmde.getTypePaiementById(id_paiement), buCmde.getPRById(monMbChoixPRConso.getPointRelais().getId()), buCmde.getConsoById(monMbCnxConso.getConsommateurConnecte().getId()));
		for(LigneCommande l : monMbTestPanier.getLigneCommandes()) {
			buCmde.creerUneLigneCommande(null, l.getQuantiteCommandee(), buCmde.getCommandebyId(idNouvelleCommande), l.getProduit());
		}
		// Je crée une commande contenant les infos de la commande nouvellement créée en base.
		commande = buCmde.getCommandebyId(idNouvelleCommande);
		commande.setPointRelais( monMbChoixPRConso.getPointRelais());
		List<LigneCommande> listTemp = new ArrayList<LigneCommande>();
		for(LigneCommande lgnCmd : monMbTestPanier.getLigneCommandes()) {
			listTemp.add(lgnCmd);
		}
		commande.setLgnCommandes(listTemp);
		
		return "/commande/14RecapitulatifCommande/recapitulatifCommande.xhtml?faces-redirect=true";
	}

	public Date calculDateLivraison() {
		Date dateLivraison= new Date();
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(new Date());
		int today = cal.get(Calendar.DAY_OF_WEEK);
		switch (today) {
		case GregorianCalendar.THURSDAY:
			cal.add(cal.DATE, 4);			
			break;
		case GregorianCalendar.FRIDAY:
			cal.add(cal.DATE, 4);			
			break;
		default:
			cal.add(cal.DATE, 3);
			break;
		}
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
	
	public String getCodePostalPointRelais() {
		System.out.println("je passe par le point relais");
		return commande.getPointRelais().getAdresses().get(0).getCodePostal().getCodePostal();
	}
	
	public String getVillePointRelais() {
		System.out.println("je passe par la ville");
		return commande.getPointRelais().getAdresses().get(0).getCodePostal().getVilles().get(0).getNom();
	}
	
	public String getAdressePointRelais() {
		System.out.println("je passe par l'adresse");
		return commande.getPointRelais().getAdresses().get(0).getNumeroRue() + " " +
				 commande.getPointRelais().getAdresses().get(0).getNomRue();
	}


}
