package fr.afcepf.ai101.filetGarni.data.impl;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.ai101.filetGarni.data.api.IDaoUtilisateur;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Utilisateur;

@Remote(IDaoUtilisateur.class)
@Stateless
public class DaoUtilisateur implements IDaoUtilisateur {

	@PersistenceContext(unitName = "FiletGarni_Data_Impl")
	private EntityManager em;
	
    public DaoUtilisateur() {
    }

    public void creer() {
        // TODO implement here
    }

    public void modifier() {
        // TODO implement here
    }

    public void supprimer() {
        // TODO implement here
    }

    public Utilisateur getByID(Integer id) {
        // TODO implement here
        return null;
    }

    public java.util.List<Utilisateur> getByNom(String nom) {
        // TODO implement here
        return null;
    }

    public java.util.List<Utilisateur> getAll() {
        // TODO implement here
        return null;
    }

    public java.util.List<Utilisateur> getByType(String type) {
        // TODO implement here
        return null;
    }

}