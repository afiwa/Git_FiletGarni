package fr.afcepf.ai101.filetGarni.data.api;

import fr.afcepf.ai101.groupe1.filetGarni.entity.PointRelais;

public interface IDaoPointRelais {

    public java.util.List<PointRelais> getByJour(String jour);

    public java.util.List<PointRelais> getByHoraireOuverture(java.util.Date debut, java.util.Date fin);

    public void getByHoraireOuvertureAndJour();

}