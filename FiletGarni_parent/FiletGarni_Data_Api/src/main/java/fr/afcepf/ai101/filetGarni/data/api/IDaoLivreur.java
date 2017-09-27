package fr.afcepf.ai101.filetGarni.data.api;

import fr.afcepf.ai101.groupe1.filetGarni.entity.Livreur;

public interface IDaoLivreur {

    public Livreur seConnecter(String identifiantConnexion, String mdp);
    
    public Livreur getById(Integer id_livreur);

}