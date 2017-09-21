package fr.afcepf.ai101.filetGarni.business.impl;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.ai101.filetGarni.business.api.IBusinessCompteUtilisateur;
import fr.afcepf.ai101.filetGarni.data.api.IDaoNonSalarie;
import fr.afcepf.ai101.filetGarni.data.api.IDaoProfessionnel;
import fr.afcepf.ai101.filetGarni.data.api.IDaoSalarie;
import fr.afcepf.ai101.filetGarni.data.api.IDaoUtilisateur;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Utilisateur;

@Remote(IBusinessCompteUtilisateur.class)
@Stateless
public class BusinessCompteUtilisateur implements IBusinessCompteUtilisateur {

	public BusinessCompteUtilisateur() {
	}

	@EJB
	private IDaoSalarie daoSalarie;

	@EJB
	private IDaoProfessionnel daoProfessionnel;

	@EJB
	private IDaoUtilisateur daoUtilisateur;

	@EJB
	private IDaoNonSalarie daoNonSalarie;

	public Utilisateur seConnecterConsommateur(String mail, String mdp) {
		return daoUtilisateur.seConnecter(mail, mdp);
	}

	public Utilisateur seConnecterProfessionnel(String identifiantConnexion, String mdp) {
		return daoProfessionnel.seConnecter(identifiantConnexion, mdp);
	}

	public Utilisateur seConnecterSalarie(String identifiantConnexion, String mdp) {
		return daoSalarie.seConnecter(identifiantConnexion, mdp);
	}

	public Boolean seDeconnecter() {
		// TODO implement here
		return null;
	}

}