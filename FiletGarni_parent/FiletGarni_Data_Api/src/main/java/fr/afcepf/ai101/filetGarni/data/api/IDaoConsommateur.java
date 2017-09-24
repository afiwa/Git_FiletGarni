package fr.afcepf.ai101.filetGarni.data.api;

import fr.afcepf.ai101.groupe1.filetGarni.entity.Consommateur;

public interface IDaoConsommateur {

    public Consommateur seConnecter(String mail, String mdp);
    
    public Consommateur getById(Integer paramIdConso);

}