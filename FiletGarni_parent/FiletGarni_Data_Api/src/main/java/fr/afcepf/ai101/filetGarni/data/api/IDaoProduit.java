package fr.afcepf.ai101.filetGarni.data.api;

import java.util.List;

import fr.afcepf.ai101.groupe1.filetGarni.entity.CategorieProduit;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Producteur;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Produit;

public interface IDaoProduit {
    
    public Produit getById(Integer id_produit);
    
    public Produit getByIdWithConditionnement(Integer id_produit);

    public java.util.List<Produit> getAllWithConditionnements();

    public java.util.List<Produit> getByIdCategorie(Integer id_categorieProduit);

    public java.util.List<Produit> getByProducteur(Producteur producteur);

    public java.util.List<Produit> getByNom(String nom);  
    
    public List<Produit> getByIdProducteur(Integer id_producteur);
    
    public void creer();

    public void modifier();

    public void supprimerbyIdProduit(Integer id_produit);

    public void rechercher();

}