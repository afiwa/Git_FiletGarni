package fr.afcepf.ai101.filetGarni.business.api;

import fr.afcepf.ai101.groupe1.filetGarni.entity.Commande;
import fr.afcepf.ai101.groupe1.filetGarni.entity.LigneCommande;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Livreur;
import fr.afcepf.ai101.groupe1.filetGarni.entity.PointRelais;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Producteur;
import fr.afcepf.ai101.groupe1.filetGarni.entity.SuiviIncident;

public interface IBusinessLivreur {

    public java.util.List<PointRelais> afficherTourneePointRelais(Livreur livreur, java.util.Date dateTournee);

    public java.util.List<Producteur> afficherTourneeProducteur(Livreur livreur, java.util.Date dateTournee);

    public java.util.List<Commande> afficherCommandeALivreePointRelais(Livreur livreur, PointRelais pointRelais, java.util.Date dateTournee);

    public java.util.List<Commande> afficherCommandeARecupererByProducteur(Livreur livreur, Producteur producteur);

    public LigneCommande validerRecuperationCommandeByProducteur(LigneCommande ligneCommande, Producteur producteur);

    public Commande validerLivraisonCommandeByPointRelais(Commande commande, PointRelais pointRelais);

    public SuiviIncident declarerIncident(Livreur livreur );

}