package fr.afcepf.ai101.filetGarni.business.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.ai101.filetGarni.business.api.IBusinessLivreur;
import fr.afcepf.ai101.filetGarni.data.api.IDaoAdresse;
import fr.afcepf.ai101.filetGarni.data.api.IDaoCodePostal;
import fr.afcepf.ai101.filetGarni.data.api.IDaoCommande;
import fr.afcepf.ai101.filetGarni.data.api.IDaoLgnCommande;
import fr.afcepf.ai101.filetGarni.data.api.IDaoLivreur;
import fr.afcepf.ai101.filetGarni.data.api.IDaoSalarie;
import fr.afcepf.ai101.filetGarni.data.api.IDaoSuiviIncident;
import fr.afcepf.ai101.filetGarni.data.api.IDaoTourneeReelleLivraison;
import fr.afcepf.ai101.filetGarni.data.api.IDaoTourneeReelleProducteur;
import fr.afcepf.ai101.filetGarni.data.api.IDaoTourneeTheorique;
import fr.afcepf.ai101.filetGarni.data.api.IDaoUtilisateur;
import fr.afcepf.ai101.filetGarni.data.api.IDaoVille;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Adresse;
import fr.afcepf.ai101.groupe1.filetGarni.entity.CodePostal;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Commande;
import fr.afcepf.ai101.groupe1.filetGarni.entity.LigneCommande;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Livreur;
import fr.afcepf.ai101.groupe1.filetGarni.entity.PointRelais;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Producteur;
import fr.afcepf.ai101.groupe1.filetGarni.entity.SuiviIncident;
import fr.afcepf.ai101.groupe1.filetGarni.entity.TourneeReelleLivraison;
import fr.afcepf.ai101.groupe1.filetGarni.entity.TourneeReelleProducteur;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Ville;

@Remote(IBusinessLivreur.class)
@Stateless
public class BusinessLivreur implements IBusinessLivreur {

    public BusinessLivreur() {
    }

    @EJB
    private IDaoVille daoVille;
    
    @EJB
    private IDaoCodePostal daoCp;
    
    @EJB
    private IDaoAdresse daoAdresse;
    
    @EJB
    private IDaoUtilisateur daoUtilisateur;

    @EJB
    private IDaoSuiviIncident daoSuiviIncident;

    @EJB
    private IDaoTourneeReelleProducteur daoTourneeReelleProducteur;

    @EJB
    private IDaoLivreur daoLivreur;

    @EJB
    private IDaoSalarie daoSalarie;

    @EJB
    private IDaoTourneeTheorique daoTourneeTheorique;

    @EJB
    private IDaoCommande daoCommande;

    @EJB
    private IDaoLgnCommande daoLgnCommande;

    @EJB
    private IDaoTourneeReelleLivraison daoTourneeReelleLivraison;

    public Map<PointRelais, List<Commande>> afficherTourneePointRelais(Livreur livreur) {
        TourneeReelleLivraison tourneeLiv = new TourneeReelleLivraison();
        tourneeLiv = daoTourneeReelleLivraison.getTourneeReelleLivraison(livreur);
        List<Commande> listeCommande = new ArrayList<>();
        listeCommande = tourneeLiv.getCommandes();
        PointRelais pr = new PointRelais();
        List<Commande> listeCommandePr = new ArrayList<>();
        Map<PointRelais,List<Commande>> mapPrCmd = new HashMap<>();
    	
        for(Commande c: listeCommande) {
        	
        	if(pr.getId() != c.getPointRelais().getId()) {
        		
        		if(pr.getId() != null) {
        			mapPrCmd.put(pr, listeCommandePr);
        		}
        		
        		pr = c.getPointRelais();
        		List<Adresse> adresse = daoAdresse.getByNonSalarie(pr);
            	pr.setAdresses(adresse);
            	CodePostal codePostal = daoCp.getByAdresse(adresse.get(0));
            	adresse.get(0).setCodePostal(codePostal);
    			List<Ville> villes = daoVille.getByCodePostal(codePostal);
    			codePostal.setVilles(villes);
    			
    			listeCommandePr.add(c);
        	}
        	else {
        		listeCommandePr.add(c);
        	}

        }

        return mapPrCmd;
    }
    

    public Map<Producteur,List<LigneCommande>> afficherTourneeProducteur(Livreur livreur) {
    	TourneeReelleProducteur tourneeProd = new TourneeReelleProducteur();
        tourneeProd = daoTourneeReelleProducteur.getTourneeReelleProducteur(livreur);
        List<LigneCommande> listeLgnCommandes = new ArrayList<>();
        listeLgnCommandes = tourneeProd.getLgnCommandes();
        Producteur producteur = new Producteur();
        List<LigneCommande> listeLigneCommandeProd;
        Map<Producteur,List<LigneCommande>> mapProdLgnCmd = new HashMap<>();

        for(LigneCommande lc: listeLgnCommandes) {
        	// Hydrater produit conditionnement
        	if( mapProdLgnCmd.containsKey(lc.getProduit().getProducteur())) {
        		mapProdLgnCmd.get(lc.getProduit().getProducteur()).add(lc);
        	}
        	else {
        		listeLigneCommandeProd = new ArrayList<>();
        		listeLigneCommandeProd.add(lc);
        		producteur = lc.getProduit().getProducteur();
        		List<Adresse> adresse = daoAdresse.getByNonSalarie(producteur);
        		producteur.setAdresses(adresse);
        		CodePostal codePostal = daoCp.getByAdresse(adresse.get(0));
        		adresse.get(0).setCodePostal(codePostal);
        		List<Ville> villes = daoVille.getByCodePostal(codePostal);
        		codePostal.setVilles(villes);
        		mapProdLgnCmd.put(producteur, listeLigneCommandeProd);
        	}

        }
        return mapProdLgnCmd;
    }
    
    /*
	
	listeLigneCommandeProd.add(lc);*/

    public java.util.List<Commande> afficherCommandeALivreePointRelais(Livreur livreur, PointRelais pointRelais, java.util.Date dateTournee) {
        // TODO implement here
        return null;
    }

    public java.util.List<Commande> afficherCommandeARecupererByProducteur(Livreur livreur, Producteur producteur) {
        // TODO implement here
        return null;
    }

    public LigneCommande validerRecuperationCommandeByProducteur(LigneCommande ligneCommande, Producteur producteur) {
        // TODO implement here
        return null;
    }

    public Commande validerLivraisonCommandeByPointRelais(Commande commande, PointRelais pointRelais) {
        // TODO implement here
        return null;
    }

    public SuiviIncident declarerIncident(Livreur livreur ) {
        // TODO implement here
        return null;
    }
    
    public Livreur getLivreurById(Integer id_livreur) {
    	
    	return daoLivreur.getById(id_livreur);
    }

}