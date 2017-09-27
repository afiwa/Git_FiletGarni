package fr.afcepf.ai101.filetGarni.data.api;

import java.util.List;

import fr.afcepf.ai101.groupe1.filetGarni.entity.CategorieProduit;

public interface IDaoCategorieProduit {
	
	public List<CategorieProduit> getCategoriesByIdCategorie(Integer id_categorieProduit);
	
	public List<CategorieProduit> getAllCategorie();

}