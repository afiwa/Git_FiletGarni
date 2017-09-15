package afcepf.ai101.groupe1.filetGarni.entity;

import java.util.*;

/**
 * 
 */
public class TourneeTheorique {

    /**
     * Default constructor
     */
    public TourneeTheorique() {
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
    private java.util.Date dateTournee;

    /**
     * 
     */
    private Integer nbKm;

    /**
     * 
     */
    private java.util.Date heureDebut;

    /**
     * 
     */
    private java.util.Date heureFin;

    /**
     * 
     */
    private Set<SuiviIncident> suivisIncidents;

    /**
     * 
     */
    private Set<Ville> villes;

}