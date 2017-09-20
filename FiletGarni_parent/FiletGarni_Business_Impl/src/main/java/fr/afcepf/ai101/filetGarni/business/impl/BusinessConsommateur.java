package fr.afcepf.ai101.filetGarni.business.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.ai101.filetGarni.business.api.IBusinessConsommateur;
import fr.afcepf.ai101.filetGarni.data.api.IDaoAdresse;
import fr.afcepf.ai101.filetGarni.data.api.IDaoCodePostal;
import fr.afcepf.ai101.filetGarni.data.api.IDaoCommande;
import fr.afcepf.ai101.filetGarni.data.api.IDaoLgnCommande;
import fr.afcepf.ai101.filetGarni.data.api.IDaoRegion;
import fr.afcepf.ai101.filetGarni.data.api.IDaoVille;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Commande;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Consommateur;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Evaluation;

@Remote(IBusinessConsommateur.class)
@Stateless
public class BusinessConsommateur implements IBusinessConsommateur {

    public BusinessConsommateur() {
    }

    @EJB
    private IDaoCommande daoCommande;

    @EJB
    private IDaoLgnCommande daoLgnCommande;

    @EJB
    private IDaoCodePostal daoCodePostal;

    @EJB
    private IDaoRegion daoRegion;

    @EJB
    private IDaoVille daoVille;

    @EJB
    private IDaoAdresse daoAdresse;

	@Override
	public void creerEvaluation(Evaluation paramEvaluation, Consommateur paramConsommateur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Commande> getHistoriqueCommande(Consommateur paramConsommateur) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Commande> getCommandesEnCours(Consommateur paramConsommateur) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Commande getCommandeEnCours(Consommateur paramConsommateur, Commande paramCommande) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Commande getCommandeRecuperee(Consommateur paramConsommateur, Commande paramCommande) {
		// TODO Auto-generated method stub
		return null;
	}

}