package fr.afcepf.ai101.filetGarni.business.api;

import java.util.List;

import fr.afcepf.ai101.groupe1.filetGarni.entity.CategorieProducteur;
import fr.afcepf.ai101.groupe1.filetGarni.entity.CategorieProduit;
import fr.afcepf.ai101.groupe1.filetGarni.entity.CategorieRecette;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Commande;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Conditionnement;
import fr.afcepf.ai101.groupe1.filetGarni.entity.LigneCommande;
import fr.afcepf.ai101.groupe1.filetGarni.entity.PointRelais;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Producteur;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Produit;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Recette;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Region;


public interface IBusinessCommande {

    public java.util.List<Produit> getAllProduits();

    public java.util.List<Produit> getProduitByNom(String nom , Region region);

    public java.util.List<Produit> getProduitByIdCategorie(Integer id_categorieProduit, Boolean premierPassage);

    public java.util.List<Produit> getProduitsByIdProducteur(Integer id_producteur);
    
    public Produit getProduitStockBasByIdProducteur(Integer id_producteur);

    public Produit getProduitById(Integer id_produit);
    
    public void supprimerUnProduit(Integer id_produit);

    public Commande creerUneCommande();
    
    public LigneCommande ajouterLigneCommande(LigneCommande ligneCommande, Commande commande);

    public LigneCommande modifierUneLigneDeCommande(LigneCommande ligneCommande, Double quantite);

    public Commande affecterLePointRelais(Commande commande, PointRelais pointrelais);

    public List<Producteur> getAllProducteurs();
    
    public java.util.List<Producteur> getProducteurByRegion(Region region);

    public java.util.List<Producteur> getProducteurbyIdCategorie(Integer id_categorie);

    public Producteur getProducteurById(Integer id_producteur);
    
    public Producteur getProducteurByIdProduit(Integer id_produit);

    public java.util.List<Recette> getAllRecettes();

    public java.util.List<Recette> getRecetteByCategorie(Integer id_categorie);

    public Recette getRecetteByIdWithAllProduitRecette(Integer id_recette);

    public Commande getCommandebyId(Integer id_commande);

	public Produit getProduitByIdWithConditionnements(Integer paramId_produit);

	public List<LigneCommande> getAllLigneCommandesByIdCommande(Integer id_commande);
	
	public List<Conditionnement> getAllConditionnements();
	
	public List<CategorieProduit> getAllCategorieProduit();

}