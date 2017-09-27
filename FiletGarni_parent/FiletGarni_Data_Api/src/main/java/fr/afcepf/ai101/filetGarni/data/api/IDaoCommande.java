package fr.afcepf.ai101.filetGarni.data.api;

import java.util.List;

import fr.afcepf.ai101.groupe1.filetGarni.entity.Commande;
import fr.afcepf.ai101.groupe1.filetGarni.entity.LigneCommande;
import fr.afcepf.ai101.groupe1.filetGarni.entity.PointRelais;

public interface IDaoCommande {

    public Integer creer(Commande c);
    
    public void supprimer();

    public void rechercher();

    public Commande getById(Integer idCommande);

    public void validerCmde();

    public void payerCmde();

    public java.util.List<Commande> getByUtilisateur(Integer idUtilisateur);

    public Commande updateTypePaiement(Integer id);

    public Commande updateDatePaiement(Integer id);

    public Commande updateDatePreparation(Integer id);

    public Commande updateDateRecuperationClient(Integer id);

    public Commande updatePointRelais(PointRelais id_pointRelais);
}