package fr.afcepf.ai101.filetGarni.business.api;

import java.util.Date;
import java.util.List;
import java.util.Set;

import fr.afcepf.ai101.groupe1.filetGarni.entity.Commande;
import fr.afcepf.ai101.groupe1.filetGarni.entity.LigneCommande;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Producteur;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Produit;
import fr.afcepf.ai101.groupe1.filetGarni.entity.SuiviIndisponibilite;

public interface IBusinessProducteur {

    public java.util.List<LigneCommande> afficherLigneCommandeDuJour(Producteur producteur);

    public java.util.List<LigneCommande> afficherLigneCommandeDeLaSemaine(Producteur producteur);

    public java.util.List<LigneCommande> afficherHistoriqueDesLignesCommandes(Producteur producteur);

    public LigneCommande validerLigneDeCommande(Producteur producteur, LigneCommande lgnCmd);

    public void ajouterUnProduit(Produit produit, Producteur roducteur);

    public void modifierUnProduit(Produit produit);

    public Boolean supprimerUnProduit(Produit produit);

    public SuiviIndisponibilite declarerIndispo(SuiviIndisponibilite indispo, LigneCommande ligneCommande);
    
    public Set<Commande> getCommandesByIdProducteurByDateLivraison(Integer id_producteur, Date date_livraison);

}