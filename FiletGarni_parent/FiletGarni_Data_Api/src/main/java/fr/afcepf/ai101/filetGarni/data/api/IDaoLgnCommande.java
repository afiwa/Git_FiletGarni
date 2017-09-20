package fr.afcepf.ai101.filetGarni.data.api;

import fr.afcepf.ai101.groupe1.filetGarni.entity.LigneCommande;

public interface IDaoLgnCommande {

    public void creerUnePremiereLigneCommande();

    public LigneCommande ajouter(Integer id_commande);

    public void supprimer();

    public LigneCommande updateQuantite(Double quantite);

    public java.util.List<LigneCommande> getByCommande(Integer id);

    public java.util.List<LigneCommande> getByProducteur(Integer id_Producteur);

    public LigneCommande updateDatePreparation();

    public LigneCommande updateDateRecuperationLivreur();

    public LigneCommande updateDateRecuperationClient();

    public void signalerRetardLivraison();

}