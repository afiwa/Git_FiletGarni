package fr.afcepf.ai101.filetGarni.business.api;

import java.util.Date;
import java.util.List;

import fr.afcepf.ai101.groupe1.filetGarni.entity.CategorieProducteur;
import fr.afcepf.ai101.groupe1.filetGarni.entity.CategorieRecette;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Commande;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Consommateur;
import fr.afcepf.ai101.groupe1.filetGarni.entity.LigneCommande;
import fr.afcepf.ai101.groupe1.filetGarni.entity.PointRelais;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Producteur;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Produit;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Recette;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Region;
import fr.afcepf.ai101.groupe1.filetGarni.entity.TypePaiement;


public interface IBusinessCommandeMarion {

    public java.util.List<Produit> getAllProduits();

    public java.util.List<Produit> getProduitByNom(String nom , Region region);

    public java.util.List<Produit> getProduitByIdCategorie(Integer id_categorieProduit, Boolean premierPassage);

    public java.util.List<Produit> getProduitByProducteur(Region region, Producteur producteur);

    public Produit getProduitById(Integer id_produit);

    public Commande creerUneCommande();
    
    //Ajout Marion
    public Commande creerUneCommande(Integer paramId, Date paramDatePaiement, Date paramDateValidation,
			Date paramDateLivraisonPrevue, TypePaiement paramTypePaiement, PointRelais paramPointRelais,
			Consommateur paramConsommateur);
    
    public LigneCommande creerUneLigneCommande(Integer paramId, Double paramQuantiteCommandee,
    		Commande paramCommande, Produit paramProduit);
    
    public TypePaiement getTypePaiementById(Integer paramIdTypePaiement);
    
    public Consommateur getConsoById(Integer paramIdConso);
    
    public PointRelais getPRById(Integer paramIdPR);
    
    public Integer getQuantiteEnStock(Integer paramIdProduit);
    
    //fin ajout

    public LigneCommande ajouterLigneCommande(LigneCommande ligneCommande, Commande commande);

    public LigneCommande modifierUneLigneDeCommande(LigneCommande ligneCommande, Double quantite);

    public Commande affecterLePointRelais(Commande commande, PointRelais pointrelais);

    public List<Producteur> getAllProducteurs();
    
    public java.util.List<Producteur> getProducteurByRegion(Region region);

    public java.util.List<Producteur> getProducteurbyCategorie(CategorieProducteur categorie);

    public Producteur getProducteurById(Integer id_producteur);

    public java.util.List<Recette> getAllRecettes();

    public java.util.List<Recette> getRecetteByCategorie(CategorieRecette categorie);

    public Recette getRecetteByIdWithAllProduitRecette(Integer id_recette);

    public Commande getCommandebyId(Integer id_commande);

	public Produit getProduitByIdWithConditionnements(Integer paramId_produit);

	

}