package fr.afcepf.ai101.filetGarni.data.api;

import java.util.List;

import fr.afcepf.ai101.groupe1.filetGarni.entity.CategorieProducteur;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Producteur;

public interface IDaoProducteur {

    public java.util.List<Producteur> getByIdCategorie(Integer id_categorie);
    
    public List<Producteur> getAll();
    
    public List<Producteur> getAllWithCategories();
    
    public Producteur getByIdWithAdresses(Integer id_producteur);
    
    public Producteur getByIdProduit(Integer id_produit);

}