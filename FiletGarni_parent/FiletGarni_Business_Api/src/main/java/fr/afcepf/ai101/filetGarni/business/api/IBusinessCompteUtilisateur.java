package fr.afcepf.ai101.filetGarni.business.api;

import fr.afcepf.ai101.groupe1.filetGarni.entity.Utilisateur;

public interface IBusinessCompteUtilisateur {

    public Utilisateur seConnecterConsommateur(String mail, String mdp);
    
    public Utilisateur seConnecterSalarie(String identifiantConnexion, String mdp);
    
    public Utilisateur seConnecterProfessionnel(String identifiantConnexion, String mdp);

    public Boolean seDeconnecter();

}