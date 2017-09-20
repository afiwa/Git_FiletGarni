package fr.afcepf.ai101.filetGarni.data.api;

import fr.afcepf.ai101.groupe1.filetGarni.entity.CategorieProduit;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Producteur;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Produit;

public interface IDaoProduit {

    public void creer();

    public void modifier();

    public void supprimer();

    public void rechercher();

    public java.util.List<Produit> getAll();

    public java.util.List<Produit> getByCategorie(CategorieProduit categorieProduit);

    public java.util.List<Produit> getByProducteur(Producteur producteur);

    public java.util.List<Produit> getByNom(String nom);

}