package fr.afcepf.ai101.groupe1.filetGarni.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="horairesouverture")
public class HorairesOuverture implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_horaires", nullable=false)
    private Integer id;

    @Column(name="heure_debut_ouverture", nullable = false, length = 20)
    private String heureDeDébut;

    @Column(name="heure_fin_ouverture", nullable = false, length = 20)
    private String heureDeFin;

    
    @ManyToMany(mappedBy="horaires")
    private List<Jour> jours;
    
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHeureDeDébut() {
		return heureDeDébut;
	}

	public void setHeureDeDébut(String heureDeDébut) {
		this.heureDeDébut = heureDeDébut;
	}

	public String getHeureDeFin() {
		return heureDeFin;
	}

	public void setHeureDeFin(String heureDeFin) {
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

	public HorairesOuverture(Integer id, String heureDeDébut, String heureDeFin) {
		super();
		this.id = id;
		this.heureDeDébut = heureDeDébut;
		this.heureDeFin = heureDeFin;
	}
	
	

}