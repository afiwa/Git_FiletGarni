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
import javax.persistence.Transient;

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
	
	// TODO ManytoOne
	@Transient
	private CodePostal codePostal;
	
	@OneToMany(mappedBy = "ville")
    private List<Adresse> adresses;
	
	// TODO ManytoOne
	@Transient
    private Livreur livreur;
    
    // TODO ManytoOne
	@Transient
    private TourneeTheorique tourneeTheorique;
    
    public Ville() {
    }

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