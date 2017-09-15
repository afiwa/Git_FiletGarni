package afcepf.ai101.groupe1.filetGarni.entity;

import java.util.*;

/**
 * 
 */
public class LigneCommande {

    /**
     * Default constructor
     */
    public LigneCommande() {
    }

    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private Double quantiteCommandee;

    /**
     * 
     */
    private Double quantiteLivree;

    /**
     * 
     */
    private java.util.Date dateValidationPreparationProducteur;

    /**
     * 
     */
    private java.util.Date dateRecuperationLivreur;

    /**
     * 
     */
    private java.util.Date dateRecuperationClient;

    /**
     * 
     */
    private Commande commande;

    /**
     * 
     */
    private Produit produit;

    /**
     * 
     */
    private TourneeReelleProducteur tourneeReelleProducteur;

    /**
     * 
     */
    private SuiviIndisponibilite indispo;

    /**
     * 
     */
    public void getMontantLgnCommande() {
        // TODO implement here
    }

}