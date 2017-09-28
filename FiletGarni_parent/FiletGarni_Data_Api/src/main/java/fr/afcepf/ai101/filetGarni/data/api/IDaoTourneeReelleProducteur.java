package fr.afcepf.ai101.filetGarni.data.api;

import java.util.Date;

import fr.afcepf.ai101.groupe1.filetGarni.entity.Livreur;
import fr.afcepf.ai101.groupe1.filetGarni.entity.TourneeReelleProducteur;

/**
 * 
 */
public interface IDaoTourneeReelleProducteur {

    /**
     * 
     */
    public void creer();

    /**
     * 
     */
    public void supprimer();

    /**
     * 
     */
    public void modifier();

    /**
     * 
     */
    public void rechercher();
    
    public TourneeReelleProducteur getTourneeReelleProducteur(Livreur livreur);

}