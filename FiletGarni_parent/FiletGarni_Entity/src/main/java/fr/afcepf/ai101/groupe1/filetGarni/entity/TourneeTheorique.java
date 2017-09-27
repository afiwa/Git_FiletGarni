package fr.afcepf.ai101.groupe1.filetGarni.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tourneetheorique")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_tournee")
public class TourneeTheorique implements Serializable{
    
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id_tournee_theorique", nullable= false)
	private Integer id;

	@Column(name="libelle_tournee_theorique", nullable= true, length=50)
    private String libelle;

	@Column(name="date_tournee_theorique", nullable= true)
	@Temporal(TemporalType.TIMESTAMP)
    private java.util.Date dateTournee;

	@Column(name="nbkm_tournee_theorique", nullable= true)
    private Integer nbKm;

	@Column(name="heure_debut_tournee_theorique", nullable= true)
	@Temporal(TemporalType.TIMESTAMP)
    private java.util.Date heureDebut;

	@Column(name="heure_fin_tournee_theorique", nullable= true)
	@Temporal(TemporalType.TIMESTAMP)
    private java.util.Date heureFin;

    @OneToMany(mappedBy="tourneeTheorique")
    private List<SuiviIncident> suivisIncidents;

    @OneToMany(mappedBy="tourneeTheorique")
    private List<Ville> villes;
    
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public java.util.Date getDateTournee() {
		return dateTournee;
	}

	public void setDateTournee(java.util.Date dateTournee) {
		this.dateTournee = dateTournee;
	}

	public Integer getNbKm() {
		return nbKm;
	}

	public void setNbKm(Integer nbKm) {
		this.nbKm = nbKm;
	}

	public java.util.Date getHeureDebut() {
		return heureDebut;
	}

	public void setHeureDebut(java.util.Date heureDebut) {
		this.heureDebut = heureDebut;
	}

	public java.util.Date getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(java.util.Date heureFin) {
		this.heureFin = heureFin;
	}

	public List<SuiviIncident> getSuivisIncidents() {
		return suivisIncidents;
	}

	public void setSuivisIncidents(List<SuiviIncident> suivisIncidents) {
		this.suivisIncidents = suivisIncidents;
	}

	public List<Ville> getVilles() {
		return villes;
	}

	public void setVilles(List<Ville> villes) {
		this.villes = villes;
	}

	public TourneeTheorique() {
    }
	
	public TourneeTheorique(Integer id, String libelle, Date dateTournee, Integer nbKm, Date heureDebut,
			Date heureFin) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.dateTournee = dateTournee;
		this.nbKm = nbKm;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
	}


}