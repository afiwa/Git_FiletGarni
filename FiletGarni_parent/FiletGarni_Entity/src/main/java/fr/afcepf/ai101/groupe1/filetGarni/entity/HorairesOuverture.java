package fr.afcepf.ai101.groupe1.filetGarni.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

    
    @ManyToOne
    @JoinColumn(name="id_jour", nullable=true, foreignKey=
    @ForeignKey(name="id_jour"))
    private Jour jour;
    
    @ManyToOne
    @JoinColumn(name="id_pointrelais", nullable=true, foreignKey=
    @ForeignKey(name="id_utilisateur"))
    private PointRelais pointRelais;
    
   

	public HorairesOuverture() {
    }

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

	public Jour getJour() {
		return jour;
	}

	public void setJour(Jour jour) {
		this.jour = jour;
	}

	public PointRelais getPointRelais() {
		return pointRelais;
	}

	public void setPointRelais(PointRelais pointRelais) {
		this.pointRelais = pointRelais;
	}

	public HorairesOuverture(Integer id, String heureDeDébut, String heureDeFin, Jour jour, PointRelais pointRelais) {
		super();
		this.id = id;
		this.heureDeDébut = heureDeDébut;
		this.heureDeFin = heureDeFin;
		this.jour = jour;
		this.pointRelais = pointRelais;
	}

	
	

}