package afcepf.ai101.groupe1.filetGarni.entity;

import java.util.*;

/**
 * 
 */
public class Adresse {

    /**
     * Default constructor
     */
    public Adresse() {
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
    private String numeroRue;

    /**
     * 
     */
    private Double latitude;

    /**
     * 
     */
    private Double longitude;

    /**
     * 
     */
    private Ville ville;

    /**
     * 
     */
    private Set<NonSalarie> nonSalaries;

    /**
     * 
     */
    private PointRelais pointRelais;

}