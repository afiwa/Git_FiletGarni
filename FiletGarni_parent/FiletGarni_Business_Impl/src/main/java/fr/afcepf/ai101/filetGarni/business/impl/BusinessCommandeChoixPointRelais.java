package fr.afcepf.ai101.filetGarni.business.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.ai101.filetGarni.business.api.IBusinessCommandeChoixPointRelais;
import fr.afcepf.ai101.filetGarni.data.api.IDaoCodePostal;
import fr.afcepf.ai101.filetGarni.data.api.IDaoHorairesOuverture;
import fr.afcepf.ai101.filetGarni.data.api.IDaoPointRelais;
import fr.afcepf.ai101.filetGarni.data.api.IDaoVille;
import fr.afcepf.ai101.groupe1.filetGarni.entity.CodePostal;
import fr.afcepf.ai101.groupe1.filetGarni.entity.HorairesOuverture;
import fr.afcepf.ai101.groupe1.filetGarni.entity.PointRelais;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Ville;

@Remote(IBusinessCommandeChoixPointRelais.class)
@Stateless
public class BusinessCommandeChoixPointRelais implements IBusinessCommandeChoixPointRelais {

	@EJB
	private IDaoPointRelais daoPointRelais;
	
	@EJB
    private IDaoVille daoVille;
    
    @EJB
    private IDaoCodePostal daoCodePostal;
	
    @EJB
    private IDaoHorairesOuverture daoHoraire;

	@Override
	public List<PointRelais> getAllPointRelais() {
		List<PointRelais> pointrelais = new ArrayList<>();
		CodePostal codePostal = new CodePostal();
		List<Ville> villes = new ArrayList<>();
		List<HorairesOuverture> horaire = new ArrayList<>();
		pointrelais = daoPointRelais.getAll();

		for(PointRelais pr : pointrelais) {
			codePostal = daoCodePostal.getByAdresse(pr.getAdresses().get(0));
			villes = daoVille.getByCodePostal(codePostal);
			horaire = daoHoraire.getByPointRelais(pr);
			codePostal.setVilles(villes);
			pr.getAdresses().get(0).setCodePostal(codePostal);
			pr.setListeHorairesOuverture(horaire);
		}
		
		return pointrelais;
	}


	public BusinessCommandeChoixPointRelais() {
		
	}
	
	
  
}
