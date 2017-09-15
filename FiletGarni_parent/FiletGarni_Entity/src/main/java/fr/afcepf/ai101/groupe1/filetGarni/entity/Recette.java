package afcepf.ai101.groupe1.filetGarni.entity;

import java.util.*;

/**
 * 
 */
public class Recette {

    /**
     * Default constructor
     */
    public Recette() {
    }

    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String libelle;

    /**
     * 
     */
    private String descriptif;

    /**
     * 
     */
    private Set<CategorieRecette> categorieRecettes;

    /**
     * 
     */
    private Set<produitRecette> produitRecettes;

}