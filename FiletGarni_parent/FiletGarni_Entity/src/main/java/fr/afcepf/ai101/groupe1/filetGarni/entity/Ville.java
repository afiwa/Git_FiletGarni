package fr.afcepf.ai101.groupe1.filetGarni.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ville")
public class Ville implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_ville", nullable = false)
	private Integer id;

	@Column(name="nom_ville", nullable = false, length = 50)
	private String nom;
	
	@Column(name="code_commune_cp", nullable=true, length=10)
    private String codeCommune;

	@ManyToMany(mappedBy = "villes")
	private List<CodePostal> codePostaux;
	
	@ManyToOne
	@JoinColumn(name="id_region_tville", nullable=true, foreignKey=
	@ForeignKey(name="FK_region_tville"))
    private Region region;

	@ManyToOne
	@JoinColumn(name="id_livreur_tville", nullable=true, foreignKey = 
	@ForeignKey(name="FK_livreur_tville"))
	private Livreur livreur;

	@ManyToOne
	@JoinColumn(name="id_tourneetheo_tville", nullable=true, foreignKey = 
	@ForeignKey(name="FK_tourneetheo_ville"))
	private TourneeTheorique tourneeTheorique;

	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCodeCommune() {
		return codeCommune;
	}

	public void setCodeCommune(String codeCommune) {
		this.codeCommune = codeCommune;
	}

	public List<CodePostal> getCodePostaux() {
		return codePostaux;
	}

	public void setCodePostaux(List<CodePostal> codePostaux) {
		this.codePostaux = codePostaux;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public Livreur getLivreur() {
		return livreur;
	}

	public void setLivreur(Livreur livreur) {
		this.livreur = livreur;
	}

	public TourneeTheorique getTourneeTheorique() {
		return tourneeTheorique;
	}

	public void setTourneeTheorique(TourneeTheorique tourneeTheorique) {
		this.tourneeTheorique = tourneeTheorique;
	}

	public Ville() {
	}

	public Ville(Integer paramId, String paramNom, String paramCodeCommune, Region paramRegion, Livreur paramLivreur,
			TourneeTheorique paramTourneeTheorique) {
		super();
		id = paramId;
		nom = paramNom;
		codeCommune = paramCodeCommune;
		region = paramRegion;
		livreur = paramLivreur;
		tourneeTheorique = paramTourneeTheorique;
	}

	
	
	
	

	

}