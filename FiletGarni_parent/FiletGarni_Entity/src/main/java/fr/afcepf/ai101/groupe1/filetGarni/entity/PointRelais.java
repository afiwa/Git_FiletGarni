package afcepf.ai101.groupe1.filetGarni.entity;

import java.util.*;

/**
 * 
 */
public class PointRelais extends Professionnel {

    /**
     * Default constructor
     */
    public PointRelais() {
    }

    /**
     * 
     */
    private Set<Jour> jours;

    /**
     * 
     */
    private Adresse adresse;

    /**
     * 
     */
    private Set<Commande> commandes;

    /**
     * 
     */
    private Set<PeriodeDAbsence> periodeAbsences;

}