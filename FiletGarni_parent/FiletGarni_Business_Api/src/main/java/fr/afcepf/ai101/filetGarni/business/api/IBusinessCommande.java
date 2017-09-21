package fr.afcepf.ai101.filetGarni.business.api;

import fr.afcepf.ai101.groupe1.filetGarni.entity.CategorieProducteur;
import fr.afcepf.ai101.groupe1.filetGarni.entity.CategorieProduit;
import fr.afcepf.ai101.groupe1.filetGarni.entity.CategorieRecette;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Commande;
import fr.afcepf.ai101.groupe1.filetGarni.entity.LigneCommande;
import fr.afcepf.ai101.groupe1.filetGarni.entity.PointRelais;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Producteur;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Produit;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Recette;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Region;


public interface IBusinessCommande {

    public java.util.List<Produit> getProduitByRegion(Region region);

    public java.util.List<Produit> getProduitByNom(String nom , Region region);

    public java.util.List<Produit> getProduitByCategorie(CategorieProduit categorie, Region region);

    public java.util.List<Produit> getProduitByProducteur(Region region, Producteur producteur);

    public Produit getProduitById(Integer id_produit);

    public Commande creerUneCommande();

    public LigneCommande ajouterLigneCommande(LigneCommande ligneCommande, Commande commande);

    public LigneCommande modifierUneLigneDeCommande(LigneCommande ligneCommande, Double quantite);

    public Commande affecterLePointRelais(Commande commande, PointRelais pointrelais);

    public java.util.List<Producteur> getProducteurByRegion(Region region);

    public java.util.List<Producteur> getProducteurbyCategorie(CategorieProducteur categorie);

    public Producteur getProducteurById(Integer id_producteur);

    public java.util.List<Recette> getAllRecettes();

    public java.util.List<Recette> getRecetteByCategorie(CategorieRecette categorie);

    public Recette getRecetteById(Integer id_recette);

    public Commande getCommandebyId(Integer id_commande);

}