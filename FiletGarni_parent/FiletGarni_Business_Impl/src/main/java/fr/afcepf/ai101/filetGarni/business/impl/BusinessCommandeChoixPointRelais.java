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
	
//	@Override
//	public PointRelais getPRById(Integer paramIdPR) {
//		PointRelais pointRelais = new PointRelais();
//		CodePostal codePostal = new CodePostal();
//		List<Ville> villes = new ArrayList<>();
//		List<HorairesOuverture> horaire = new ArrayList<>();
//
//			codePostal = daoCodePostal.getByAdresse(pr.getAdresses().get(0));
//			villes = daoVille.getByCodePostal(codePostal);
//			horaire = daoHoraire.getByPointRelais(pointRelais);
//			codePostal.setVilles(villes);
//			pointrelais.getAdresses().get(0).setCodePostal(codePostal);
//			pointrelais.setListeHorairesOuverture(horaire);
//		
//		return pointrelais;
//		
//		return daoPointRelais.getById(paramIdPR);
//	}


	public double DistanceEntreDeuxPointRelais(double lat_a_degre,double lon_a_degre,double lat_b_degre,double lon_b_degre){

		double Rayon = 6378000; //Rayon de la terre en mètre
		
		double lat_a = convertRad(lat_a_degre);
		double lon_a = convertRad(lon_a_degre);
		double lat_b = convertRad(lat_b_degre);
		double lon_b = convertRad(lon_b_degre);

		Double distance = Rayon * (Math.PI/2 - Math.asin( Math.sin(lat_b) * Math.sin(lat_a) + Math.cos(lon_b - lon_a) * Math.cos(lat_b) * Math.cos(lat_a)));

		distance = distance/1000;
		
		distance = Math.round(distance * Math.pow(10,1)) / Math.pow(10,1);
		
		return distance;
	}

	public double convertRad(double saisie){
		double y = (Math.PI *saisie)/180;
		return y;
	}
	
	public BusinessCommandeChoixPointRelais() {
		
	}
	
	
  
}
