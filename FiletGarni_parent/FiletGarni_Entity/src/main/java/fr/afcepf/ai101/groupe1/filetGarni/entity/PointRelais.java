package fr.afcepf.ai101.groupe1.filetGarni.entity;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("pointrelais")
public class PointRelais extends Professionnel {

	private static final long serialVersionUID = 1L;

	@ManyToMany
	@JoinTable(name="pointrelais_jour",joinColumns=
	@JoinColumn(name="id_pointrelais",referencedColumnName="id_utilisateur"), inverseJoinColumns=
	@JoinColumn(name="id_jour",referencedColumnName="id_jour"))
	private List<Jour> jours;
   
	@OneToMany(mappedBy="pointRelais")
    private List<Commande> commandes;

	@OneToMany(mappedBy="pointRelais")
    private List<PeriodeDAbsence> periodeAbsences;
    
	
    public List<Jour> getJours() {
		return jours;
	}

	public void setJours(List<Jour> jours) {
		this.jours = jours;
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

	public PointRelais(String identifiantConnexion, String raisonSociale, String siret, String iban, String bic) {
		super(identifiantConnexion, raisonSociale, siret, iban, bic);
	}
    
    


}