package fr.afcepf.ai101.filetGarni.data.api;

import java.util.List;

import fr.afcepf.ai101.groupe1.filetGarni.entity.CategorieProducteur;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Producteur;

public interface IDaoCategorieProducteur {
	
	List<CategorieProducteur> getCategoriesByProducteur(Producteur producteur);

}