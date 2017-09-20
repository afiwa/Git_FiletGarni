package fr.afcepf.ai101.filetGarni.business.api;

import fr.afcepf.ai101.groupe1.filetGarni.entity.Utilisateur;

public interface IBusinessCompteUtilisateur {

    public Utilisateur seConnecter(String mail, String mdp);

    public Boolean seDeconnecter();

}