package fr.afcepf.ai101.filetGarni.business.impl;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.ai101.filetGarni.business.api.IBusinessLivreur;
import fr.afcepf.ai101.filetGarni.data.api.IDaoCommande;
import fr.afcepf.ai101.filetGarni.data.api.IDaoLgnCommande;
import fr.afcepf.ai101.filetGarni.data.api.IDaoLivreur;
import fr.afcepf.ai101.filetGarni.data.api.IDaoSalarie;
import fr.afcepf.ai101.filetGarni.data.api.IDaoSuiviIncident;
import fr.afcepf.ai101.filetGarni.data.api.IDaoTourneeReelleLivraison;
import fr.afcepf.ai101.filetGarni.data.api.IDaoTourneeReelleProducteur;
import fr.afcepf.ai101.filetGarni.data.api.IDaoTourneeTheorique;
import fr.afcepf.ai101.filetGarni.data.api.IDaoUtilisateur;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Commande;
import fr.afcepf.ai101.groupe1.filetGarni.entity.LigneCommande;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Livreur;
import fr.afcepf.ai101.groupe1.filetGarni.entity.PointRelais;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Producteur;
import fr.afcepf.ai101.groupe1.filetGarni.entity.SuiviIncident;

@Remote(IBusinessLivreur.class)
@Stateless
public class BusinessLivreur implements IBusinessLivreur {

    public BusinessLivreur() {
    }

    @EJB
    private IDaoUtilisateur daoUtilisateur;

    @EJB
    private IDaoSuiviIncident daoSuiviIncident;

    @EJB
    private IDaoTourneeReelleProducteur daoTourneeReelleProducteur;

    @EJB
    private IDaoLivreur daoLivreur;

    @EJB
    private IDaoSalarie daoSalarie;

    @EJB
    private IDaoTourneeTheorique daoTourneeTheorique;

    @EJB
    private IDaoCommande daoCommande;

    @EJB
    private IDaoLgnCommande daoLgnCommande;

    @EJB
    private IDaoTourneeReelleLivraison iDaoTourneeReelleLivraison;

    public java.util.List<PointRelais> afficherTourneePointRelais(Livreur livreur, java.util.Date dateTournee) {
        // TODO implement here
        return null;
    }

    public java.util.List<Producteur> afficherTourneeProducteur(Livreur livreur, java.util.Date dateTournee) {
        // TODO implement here
        return null;
    }

    public java.util.List<Commande> afficherCommandeALivreePointRelais(Livreur livreur, PointRelais pointRelais, java.util.Date dateTournee) {
        // TODO implement here
        return null;
    }

    public java.util.List<Commande> afficherCommandeARecupererByProducteur(Livreur livreur, Producteur producteur) {
        // TODO implement here
        return null;
    }

    public LigneCommande validerRecuperationCommandeByProducteur(LigneCommande ligneCommande, Producteur producteur) {
        // TODO implement here
        return null;
    }

    public Commande validerLivraisonCommandeByPointRelais(Commande commande, PointRelais pointRelais) {
        // TODO implement here
        return null;
    }

    public SuiviIncident declarerIncident(Livreur livreur ) {
        // TODO implement here
        return null;
    }

}