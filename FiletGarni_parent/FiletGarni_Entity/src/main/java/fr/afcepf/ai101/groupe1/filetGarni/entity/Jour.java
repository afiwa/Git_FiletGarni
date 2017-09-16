package fr.afcepf.ai101.groupe1.filetGarni.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="jour")
public class Jour implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_jour", nullable=false)
	private Integer id;
    
	@Column(name="libelle_jour", nullable=false, length=10)
    private String libelle;

	@ManyToMany
	@JoinTable(name="jour_horairesouverture",joinColumns= 
	@JoinColumn(name="id_jour", referencedColumnName="id_jour"), inverseJoinColumns=
	@JoinColumn(name="id_horaires", referencedColumnName="id_horaires"))
    private List<HorairesOuverture> horaires;
    
	@ManyToMany(mappedBy="jours")
	private List<PointRelais> pointRelaisListe;

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

	public List<HorairesOuverture> getHoraires() {
		return horaires;
	}

	public void setHoraires(List<HorairesOuverture> horaires) {
		this.horaires = horaires;
	}

	public List<PointRelais> getPointRelaisListe() {
		return pointRelaisListe;
	}

	public void setPointRelaisListe(List<PointRelais> pointRelaisListe) {
		this.pointRelaisListe = pointRelaisListe;
	}

	public Jour() {
    }

	public Jour(Integer id, String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}
	
	
}