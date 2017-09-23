package fr.afcepf.ai101.filetGarni.data.api;

import fr.afcepf.ai101.groupe1.filetGarni.entity.CategorieProduit;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Producteur;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Produit;

public interface IDaoProduit {
    
    public Produit getById(Integer id_produit);
    
    public Produit getByIdWithConditionnement(Integer id_produit);

    public java.util.List<Produit> getAllWithConditionnements();

    public java.util.List<Produit> getByCategorieWithConditionnements(CategorieProduit categorieProduit);

    public java.util.List<Produit> getByProducteur(Producteur producteur);

    public java.util.List<Produit> getByNom(String nom);  
    
    public void creer();

    public void modifier();

    public void supprimer();

    public void rechercher();

}