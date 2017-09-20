package fr.afcepf.ai101.groupe1.filetGarni.entity;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("pointrelais")
public class PointRelais extends Professionnel {

	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy="pointRelais")
	private List<HorairesOuverture> listeHorairesOuverture;
   
	@OneToMany(mappedBy="pointRelais")
    private List<Commande> commandes;

	@OneToMany(mappedBy="pointRelais")
    private List<PeriodeDAbsence> periodeAbsences;
    
	public List<HorairesOuverture> getListeHorairesOuverture() {
		return listeHorairesOuverture;
	}

	public void setListeHorairesOuverture(List<HorairesOuverture> listeHorairesOuverture) {
		this.listeHorairesOuverture = listeHorairesOuverture;
	}

	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	public List<PeriodeDAbsence> getPeriodeAbsences() {
		return periodeAbsences;
	}

	public void setPeriodeAbsences(List<PeriodeDAbsence> periodeAbsences) {
		this.periodeAbsences = periodeAbsences;
	}

	public PointRelais() {
    }
    


}