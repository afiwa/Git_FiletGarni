package afcepf.ai101.groupe1.filetGarni.entity;

import java.util.*;

/**
 * 
 */
public class Ville {

    /**
     * Default constructor
     */
    public Ville() {
    }

    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String nom;

    /**
     * 
     */
    private CodePostal codePostal;

    /**
     * 
     */
    private Set<Adresse> adresses;

    /**
     * 
     */
    private Livreur livreur;

    /**
     * 
     */
    private TourneeTheorique tourneeTheorique;

}