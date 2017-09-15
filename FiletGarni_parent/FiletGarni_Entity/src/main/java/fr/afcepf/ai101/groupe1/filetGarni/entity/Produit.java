package afcepf.ai101.groupe1.filetGarni.entity;

import java.util.*;

/**
 * 
 */
public class Produit {

    /**
     * Default constructor
     */
    public Produit() {
    }

    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String photo;

    /**
     * 
     */
    private String libelle;

    /**
     * 
     */
    private Double prix;

    /**
     * 
     */
    private String description;

    /**
     * 
     */
    private Integer quantiteEnStock;

    /**
     * 
     */
    private java.util.Date dateCreationProduit;

    /**
     * 
     */
    private Set<Conditionnement> conditionnements;

    /**
     * 
     */
    private Set<CategorieProduit> produits;

    /**
     * 
     */
    private LigneCommande lgnCommande;

    /**
     * 
     */
    private Producteur producteur;

    /**
     * 
     */
    private produitRecette produitRecette;

}