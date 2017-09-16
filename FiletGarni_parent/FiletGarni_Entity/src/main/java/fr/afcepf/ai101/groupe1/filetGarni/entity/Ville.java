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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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


	@ManyToOne
	@JoinColumn(name="id_codepostal_tville", nullable=true, foreignKey=@ForeignKey(name="FK_codepostal_tville"))
	private CodePostal codePostal;

	@OneToMany(mappedBy = "ville")
	private List<Adresse> adresses;

	@ManyToOne
	@JoinColumn(name="id_livreur_tville", nullable=true, foreignKey = @ForeignKey(name="FK_livreur_tville"))
	private Livreur livreur;

	@ManyToOne
	@JoinColumn(name="id_tourneetheo_tville", nullable=true, foreignKey = @ForeignKey(name="FK_tourneetheo_ville"))
	private TourneeTheorique tourneeTheorique;


	public Integer getId() {
		return id;
	}

	public void setId(Integer paramId) {
		id = paramId;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String paramNom) {
		nom = paramNom;
	}

	public CodePostal getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(CodePostal paramCodePostal) {
		codePostal = paramCodePostal;
	}

	public List<Adresse> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<Adresse> paramAdresses) {
		adresses = paramAdresses;
	}

	public Livreur getLivreur() {
		return livreur;
	}

	public void setLivreur(Livreur paramLivreur) {
		livreur = paramLivreur;
	}

	public TourneeTheorique getTourneeTheorique() {
		return tourneeTheorique;
	}

	public void setTourneeTheorique(TourneeTheorique paramTourneeTheorique) {
		tourneeTheorique = paramTourneeTheorique;
	}

	public Ville() {
	}

	public Ville(Integer paramId, String paramNom, CodePostal paramCodePostal, Livreur paramLivreur,
			TourneeTheorique paramTourneeTheorique) {
		super();
		id = paramId;
		nom = paramNom;
		codePostal = paramCodePostal;
		livreur = paramLivreur;
		tourneeTheorique = paramTourneeTheorique;
	}

}