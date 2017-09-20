package fr.afcepf.ai101.groupe1.filetGarni.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

	@OneToMany(mappedBy="jour")
	private List<HorairesOuverture> horaires;
    
	
	
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

	public Jour() {
    }

	public Jour(Integer paramId, String paramLibelle) {
		super();
		id = paramId;
		libelle = paramLibelle;
	}

	

	
}