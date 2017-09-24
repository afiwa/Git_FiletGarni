package fr.afcepf.ai101.filetGarni.data.api;

import java.util.List;

import fr.afcepf.ai101.groupe1.filetGarni.entity.HorairesOuverture;
import fr.afcepf.ai101.groupe1.filetGarni.entity.PointRelais;

public interface IDaoHorairesOuverture {

    public void creer();

    public void modifier();

    public void supprimer();

    public void rechercher();
    
    public List<HorairesOuverture> getByPointRelais(PointRelais pr);

}