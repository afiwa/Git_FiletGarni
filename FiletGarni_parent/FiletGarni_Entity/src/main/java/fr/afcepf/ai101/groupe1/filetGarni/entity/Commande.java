package afcepf.ai101.groupe1.filetGarni.entity;

import java.util.*;

/**
 * 
 */
public class Commande {

    /**
     * Default constructor
     */
    public Commande() {
    }

    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private java.util.Date dateCreationCommande;

    /**
     * 
     */
    private java.util.Date datePaiement;

    /**
     * 
     */
    private java.util.Date dateValidation;

    /**
     * 
     */
    private java.util.Date dateLivraisonReelle;

    /**
     * 
     */
    private java.util.Date dateLivraisonPrevue;

    /**
     * 
     */
    private java.util.Date dateRecuperationClient;

    /**
     * 
     */
    private TypePaiement typePaiement;

    /**
     * 
     */
    private Evaluation evaluation;

    /**
     * 
     */
    private Set<LigneCommande> lgnCommandes;

    /**
     * 
     */
    private PointRelais pointRelais;

    /**
     * 
     */
    private Consommateur consommateur;

    /**
     * 
     */
    private TourneeReelleLivraison tourneeReelleLivraison;

    /**
     * 
     */
    public void getMontantCmde() {
        // TODO implement here
    }

}