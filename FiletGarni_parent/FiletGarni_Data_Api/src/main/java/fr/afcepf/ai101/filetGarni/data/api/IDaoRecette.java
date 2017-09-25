package fr.afcepf.ai101.filetGarni.data.api;

import fr.afcepf.ai101.groupe1.filetGarni.entity.Recette;

public interface IDaoRecette {

    public java.util.List<Recette> getByIdCategorieRecette(Integer id_categorie);

    public java.util.List<Recette> getAllWithAllProduitRecette();
    
    public Recette getByIdWithAllProduitRecette(Integer id_recette);

}