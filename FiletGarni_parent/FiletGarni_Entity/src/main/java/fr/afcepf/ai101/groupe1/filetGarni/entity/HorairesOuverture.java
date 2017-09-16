package fr.afcepf.ai101.groupe1.filetGarni.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="horaires_ouverture")
public class HorairesOuverture implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_horaires", nullable=false)
    private Integer id;

    @Column(name="heure_debut_ouverture")
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date heureDeDébut;

    @Column(name="heure_fin_ouverture")
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date heureDeFin;

    
    @ManyToMany(mappedBy="horaires")
    private List<Jour> jours;
    
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public java.util.Date getHeureDeDébut() {
		return heureDeDébut;
	}

	public void setHeureDeDébut(java.util.Date heureDeDébut) {
		this.heureDeDébut = heureDeDébut;
	}

	public java.util.Date getHeureDeFin() {
		return heureDeFin;
	}

	public void setHeureDeFin(java.util.Date heureDeFin) {
		this.heureDeFin = heureDeFin;
	}

	public List<Jour> getJours() {
		return jours;
	}

	public void setJours(List<Jour> jours) {
		this.jours = jours;
	}

	public HorairesOuverture() {
    }

	public HorairesOuverture(Integer id, Date heureDeDébut, Date heureDeFin) {
		super();
		this.id = id;
		this.heureDeDébut = heureDeDébut;
		this.heureDeFin = heureDeFin;
	}
	
	

}