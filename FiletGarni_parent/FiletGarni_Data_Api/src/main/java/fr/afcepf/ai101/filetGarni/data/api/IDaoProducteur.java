package fr.afcepf.ai101.filetGarni.data.api;

import fr.afcepf.ai101.groupe1.filetGarni.entity.CategorieProducteur;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Producteur;

public interface IDaoProducteur {

    public java.util.List<Producteur> getByCategorie(CategorieProducteur categorieProducteur);

}