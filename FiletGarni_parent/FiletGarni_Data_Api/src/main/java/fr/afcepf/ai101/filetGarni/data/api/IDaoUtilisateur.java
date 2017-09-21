package fr.afcepf.ai101.filetGarni.data.api;

import fr.afcepf.ai101.groupe1.filetGarni.entity.Utilisateur;

public interface IDaoUtilisateur {

    public void creer();

    public void modifier();

    public void supprimer();
    
    public Utilisateur seConnecter(String mail, String mdp);

    public Utilisateur getByID(Integer id);

    public java.util.List<Utilisateur> getByNom(String nom);

    public java.util.List<Utilisateur> getAll();

    public java.util.List<Utilisateur> getByType(String type);

}