package fr.afcepf.ai101.filetGarni.data.api;

import fr.afcepf.ai101.groupe1.filetGarni.entity.Professionnel;

public interface IDaoProfessionnel {

    public void selectionner();

    public Professionnel seConnecter(String identifiantConnexion, String mdp);

}