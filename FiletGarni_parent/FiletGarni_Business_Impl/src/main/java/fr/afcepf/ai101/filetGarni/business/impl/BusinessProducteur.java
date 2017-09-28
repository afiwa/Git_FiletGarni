package fr.afcepf.ai101.filetGarni.business.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.ai101.filetGarni.business.api.IBusinessProducteur;
import fr.afcepf.ai101.filetGarni.data.api.IDaoAdresse;
import fr.afcepf.ai101.filetGarni.data.api.IDaoCodePostal;
import fr.afcepf.ai101.filetGarni.data.api.IDaoCommande;
import fr.afcepf.ai101.filetGarni.data.api.IDaoConditionnement;
import fr.afcepf.ai101.filetGarni.data.api.IDaoLgnCommande;
import fr.afcepf.ai101.filetGarni.data.api.IDaoNonSalarie;
import fr.afcepf.ai101.filetGarni.data.api.IDaoProduit;
import fr.afcepf.ai101.filetGarni.data.api.IDaoProfessionnel;
import fr.afcepf.ai101.filetGarni.data.api.IDaoRegion;
import fr.afcepf.ai101.filetGarni.data.api.IDaoSuiviIndisponibilite;
import fr.afcepf.ai101.filetGarni.data.api.IDaoUtilisateur;
import fr.afcepf.ai101.filetGarni.data.api.IDaoVille;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Commande;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Conditionnement;
import fr.afcepf.ai101.groupe1.filetGarni.entity.LigneCommande;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Producteur;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Produit;
import fr.afcepf.ai101.groupe1.filetGarni.entity.SuiviIndisponibilite;

@Remote(IBusinessProducteur.class)
@Stateless
public class BusinessProducteur implements IBusinessProducteur {

    public BusinessProducteur() {
    }

    @EJB
    private IDaoCodePostal daoCodePostal;

    @EJB
    private IDaoAdresse daoAdresse;

    @EJB
    private IDaoVille daoVille;

    @EJB
    private IDaoProfessionnel daoProfessionnel;

    @EJB
    private IDaoNonSalarie daoNonSalarie;

    @EJB
    private IDaoRegion daoRegion;

    @EJB
    private IDaoUtilisateur daoUtilisateur;

    @EJB
    private IDaoSuiviIndisponibilite daoSuiviIndispo;

    @EJB
    private IDaoLgnCommande daoLgnCommande;

    @EJB
    private IDaoCommande daoCommande;

    @EJB
    private IDaoProduit daoProduit;
    
    @EJB
    private IDaoConditionnement daoConditionnement;


	
	@Override
	public List<LigneCommande> afficherLigneCommandeDuJour(Producteur paramProducteur) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LigneCommande> afficherLigneCommandeDeLaSemaine(Producteur paramProducteur) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LigneCommande> afficherHistoriqueDesLignesCommandes(Producteur paramProducteur) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LigneCommande validerLigneDeCommande(Producteur paramProducteur, LigneCommande paramLgnCmd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ajouterUnProduit(Produit paramProduit, Producteur paramRoducteur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifierUnProduit(Produit paramProduit) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean supprimerUnProduit(Produit paramProduit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SuiviIndisponibilite declarerIndispo(SuiviIndisponibilite paramIndispo, LigneCommande paramLigneCommande) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Commande> getCommandesByIdProducteurByDateLivraison(Integer id_producteur, Date date_livraison) {
		Set<Commande> commandesDuJourAPreparerProducteur = new HashSet<>(); 
		List<Commande> commandesDuJour = daoCommande.getAllByDate(date_livraison);
		for (Commande commande : commandesDuJour) {
			for (LigneCommande ligneCommande : commande.getLgnCommandes()) {
				if(ligneCommande.getProduit().getProducteur().getId() == id_producteur) {
					commandesDuJourAPreparerProducteur.add(commande);
				}
			}
		}
		return commandesDuJourAPreparerProducteur;
	
	}

	@Override
	public List<Conditionnement> getConditionnementsByProduit(Produit produit) {
		List<Conditionnement> conditionnements = new ArrayList<>();
		conditionnements = daoConditionnement.getByProduit(produit);
		return conditionnements;
	}
}