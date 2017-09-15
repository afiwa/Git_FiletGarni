package afcepf.ai101.groupe1.filetGarni.entity;

import java.util.*;

/**
 * 
 */
public class Producteur extends Professionnel {

    /**
     * Default constructor
     */
    public Producteur() {
    }

    /**
     * 
     */
    private String descriptionBreve;

    /**
     * 
     */
    private String descriptionDetaillee;

    /**
     * 
     */
    private String photo;

    /**
     * 
     */
    private Set<Produit> produits;

    /**
     * 
     */
    private Set<CategorieProducteur> categories;

    /**
     * 
     */
    private Set<PeriodeDAbsence> periodeAbsences;

    /**
     * 
     */
    public void getVentesMois() {
        // TODO implement here
    }

    /**
     * 
     */
    public void getNbCmdeByMois() {
        // TODO implement here
    }

    /**
     * 
     */
    public void getNbArticleVenduByMois() {
        // TODO implement here
    }

    /**
     * 
     */
    public void getCAMensuel() {
        // TODO implement here
    }

    /**
     * 
     */
    public void getCAAnnuel() {
        // TODO implement here
    }

}