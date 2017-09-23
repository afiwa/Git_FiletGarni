package fr.afcepf.ai101.filetGarni.business.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.ai101.filetGarni.business.api.IBusinessCommande;
import fr.afcepf.ai101.filetGarni.data.api.IDaoCategorieProducteur;
import fr.afcepf.ai101.filetGarni.data.api.IDaoCategorieProduit;
import fr.afcepf.ai101.filetGarni.data.api.IDaoCategorieRecette;
import fr.afcepf.ai101.filetGarni.data.api.IDaoCodePostal;
import fr.afcepf.ai101.filetGarni.data.api.IDaoCommande;
import fr.afcepf.ai101.filetGarni.data.api.IDaoConditionnement;
import fr.afcepf.ai101.filetGarni.data.api.IDaoConsommateur;
import fr.afcepf.ai101.filetGarni.data.api.IDaoLgnCommande;
import fr.afcepf.ai101.filetGarni.data.api.IDaoNonSalarie;
import fr.afcepf.ai101.filetGarni.data.api.IDaoProducteur;
import fr.afcepf.ai101.filetGarni.data.api.IDaoProduit;
import fr.afcepf.ai101.filetGarni.data.api.IDaoProduitRecette;
import fr.afcepf.ai101.filetGarni.data.api.IDaoRecette;
import fr.afcepf.ai101.filetGarni.data.api.IDaoTypePaiement;
import fr.afcepf.ai101.filetGarni.data.api.IDaoUtilisateur;
import fr.afcepf.ai101.filetGarni.data.api.IDaoVille;
import fr.afcepf.ai101.groupe1.filetGarni.entity.CategorieProducteur;
import fr.afcepf.ai101.groupe1.filetGarni.entity.CategorieProduit;
import fr.afcepf.ai101.groupe1.filetGarni.entity.CategorieRecette;
import fr.afcepf.ai101.groupe1.filetGarni.entity.CodePostal;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Commande;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Conditionnement;
import fr.afcepf.ai101.groupe1.filetGarni.entity.LigneCommande;
import fr.afcepf.ai101.groupe1.filetGarni.entity.PointRelais;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Producteur;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Produit;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Recette;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Region;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Ville;

@Remote(IBusinessCommande.class)
@Stateless
public class BusinessCommande implements IBusinessCommande {

    public BusinessCommande() {
    }

    @EJB
    private IDaoCommande daoCommande;

    @EJB
    private IDaoUtilisateur daoUtilisateur;

    @EJB
    private IDaoCategorieRecette daoCategorieRecette;

    @EJB
    private IDaoProduit daoProduit;

    @EJB
    private IDaoCategorieProduit daoCategorieProduit;

    @EJB
    private IDaoRecette daoRecette;

    @EJB
    private IDaoConditionnement daoConditionnement;

    @EJB
    private IDaoLgnCommande daoLgnCommande;

    @EJB
    private IDaoNonSalarie daoNonSalarie;

    @EJB
    private IDaoTypePaiement daoTypePaiement;

    @EJB
    private IDaoConsommateur daoConsommateur;

    @EJB
    private IDaoProduitRecette daoProduitRecette;

    @EJB
    private IDaoProducteur daoProducteur;
    
    @EJB
    private IDaoVille daoVille;
    
    @EJB
    private IDaoCodePostal daoCodePostal;
    
    @EJB
    private IDaoCategorieProducteur daoCategorieProducteur;


	@Override
	public List<Produit> getAllProduits() {
        return daoProduit.getAllWithConditionnements();
	}
	
	private List<Produit> produits = new ArrayList<>();
	
	@Override
	public List<Produit> getProduitByIdCategorie(Integer id_categorieProduit, Boolean premierPassage) {
		List<CategorieProduit> categories = daoCategorieProduit.getCategoriesByIdCategorie(id_categorieProduit);
		List<Conditionnement> conditionnements;
		if (premierPassage) {
			produits.clear();
		}
		if (categories.isEmpty()) {
			List<Produit> produitsAAjouter = new ArrayList<>();
			produitsAAjouter = daoProduit.getByIdCategorie(id_categorieProduit);
			if(!produitsAAjouter.isEmpty()) {
				for (Produit produit : produitsAAjouter) {
					conditionnements = daoConditionnement.getByProduit(produit);
					produit.setConditionnements(conditionnements);
					produits.add(produit);
					System.out.println(produit.getLibelle());
				}
			}			
				return produits;
		} else {
			for (CategorieProduit categorieProduit : categories) {
				getProduitByIdCategorie(categorieProduit.getId(),false);
			}
		}
		return produits;
	}
	
	@Override
	public Produit getProduitById(Integer paramId_produit) {
		return daoProduit.getById(paramId_produit);
	}
	
	@Override
	public Produit getProduitByIdWithConditionnements(Integer paramId_produit) {
		return daoProduit.getByIdWithConditionnement(paramId_produit);
	}

	@Override
	public List<Produit> getProduitByNom(String paramNom, Region paramRegion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produit> getProduitByProducteur(Region paramRegion, Producteur paramProducteur) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Producteur> getAllProducteurs() {
		List<Producteur> producteurs = new ArrayList<>();		
		CodePostal codePostal = new CodePostal();
		List<Ville> villes = new ArrayList<>();		
		List<CategorieProducteur> categories = new ArrayList<>();
		
		producteurs = daoProducteur.getAll();
		
		for (Producteur producteur : producteurs) {
			System.out.println(producteur.getIdentifiantConnexion());
			codePostal = daoCodePostal.getByAdresse(producteur.getAdresses().get(0));
			System.out.println(codePostal.getCodePostal() + " => " + codePostal.getId());
			villes = daoVille.getByCodePostal(codePostal);
			System.out.println(villes.size());
			codePostal.setVilles(villes);
			producteur.getAdresses().get(0).setCodePostal(codePostal);	
			categories = daoCategorieProducteur.getCategoriesByProducteur(producteur);
			producteur.setCategories(categories);
			
		}
		return producteurs;
	}

	@Override
	public List<Producteur> getProducteurByRegion(Region paramRegion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producteur> getProducteurbyCategorie(CategorieProducteur paramCategorie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producteur getProducteurById(Integer paramId_producteur) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Recette> getAllRecettes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Recette> getRecetteByCategorie(CategorieRecette paramCategorie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Recette getRecetteByIdWithAllProduitRecette(Integer paramId_recette) {
		// TODO Auto-generated method stub
		return daoRecette.getByIdWithAllProduitRecette(paramId_recette);
	}

	@Override
	public Commande creerUneCommande() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LigneCommande ajouterLigneCommande(LigneCommande paramLigneCommande, Commande paramCommande) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LigneCommande modifierUneLigneDeCommande(LigneCommande paramLigneCommande, Double paramQuantite) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Commande affecterLePointRelais(Commande paramCommande, PointRelais paramPointrelais) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Commande getCommandebyId(Integer paramId_commande) {
		// TODO Auto-generated method stub
		return null;
	}


}