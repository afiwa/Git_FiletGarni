package fr.afcepf.ai101.filetGarni.data.api;

import java.util.List;

import fr.afcepf.ai101.groupe1.filetGarni.entity.Conditionnement;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Produit;

public interface IDaoConditionnement {
	
	public List<Conditionnement> getByProduit(Produit produit);

}