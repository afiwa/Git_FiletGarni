package fr.afcepf.ai101.filetGarni.business.api;

import fr.afcepf.ai101.groupe1.filetGarni.entity.PointRelais;

public interface IBusinessCommandeChoixPointRelais {

	public java.util.List<PointRelais> getAllPointRelais();
	public double convertRad(double saisie);
	public double DistanceEntreDeuxPointRelais(double lat_a_degre,double lon_a_degre,double lat_b_degre,double lon_b_degre);
}
