package fr.afcepf.ai101.filetGarni.business.api;

import fr.afcepf.ai101.groupe1.filetGarni.entity.Commande;
import fr.afcepf.ai101.groupe1.filetGarni.entity.PointRelais;

public interface IBusinessPointRelais {

    public java.util.List<Commande> afficherCommandesLivrees(PointRelais pointRelais);

    public Commande validerRecuperationConsommateur(Integer id_commande);

}