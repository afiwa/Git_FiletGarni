package fr.afcepf.ai101.filetGarni.business.api;

import fr.afcepf.ai101.groupe1.filetGarni.entity.Commande;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Consommateur;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Evaluation;

public interface IBusinessConsommateur {

    public void creerEvaluation(Evaluation evaluation, Consommateur consommateur );

    public java.util.List<Commande> getHistoriqueCommande(Consommateur consommateur);

    public java.util.List<Commande> getCommandesEnCours(Consommateur consommateur);

    public Commande getCommandeEnCours(Consommateur consommateur, Commande commande);

    public Commande getCommandeRecuperee(Consommateur consommateur, Commande commande);

}