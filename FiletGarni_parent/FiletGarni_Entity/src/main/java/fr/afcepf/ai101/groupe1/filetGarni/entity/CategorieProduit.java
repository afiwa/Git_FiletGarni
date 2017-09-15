package afcepf.ai101.groupe1.filetGarni.entity;

import java.util.*;

/**
 * 
 */
public class CategorieProduit {

    /**
     * Default constructor
     */
    public CategorieProduit() {
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
    private CategorieProduit categorie;

    /**
     * 
     */
    private Set<CategorieProduit> categories;

    /**
     * 
     */
    private Produit variete;

}