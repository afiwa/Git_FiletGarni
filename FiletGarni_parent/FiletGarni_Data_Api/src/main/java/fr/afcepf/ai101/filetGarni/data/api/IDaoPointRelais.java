package fr.afcepf.ai101.filetGarni.data.api;

import java.util.List;

import fr.afcepf.ai101.groupe1.filetGarni.entity.Commande;
import fr.afcepf.ai101.groupe1.filetGarni.entity.PointRelais;

public interface IDaoPointRelais {

    public java.util.List<PointRelais> getByJour(String jour);

    public java.util.List<PointRelais> getByHoraireOuverture(java.util.Date debut, java.util.Date fin);

    public void getByHoraireOuvertureAndJour(String jour,java.util.Date debut, java.util.Date fin);

    public List<PointRelais> getAll();
    
    public PointRelais getById(Integer paramIdPointRelais);

	public List<Commande> getCommandesByIdPointRelais(Integer paramIdPointRelais);
}