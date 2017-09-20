package fr.afcepf.ai101.filetGarni.data.api;

import fr.afcepf.ai101.groupe1.filetGarni.entity.Recette;

public interface IDaoRecette {

    public java.util.List<Recette> getByCategorieRecette(Integer id_Categorie_Produit);

    public java.util.List<Recette> getAll();

}