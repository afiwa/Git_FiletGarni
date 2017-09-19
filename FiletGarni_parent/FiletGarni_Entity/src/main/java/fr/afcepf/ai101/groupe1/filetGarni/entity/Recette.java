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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "recette")
public class Recette implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_recette", nullable = false)
	private Integer id;
	
	@Column(name="photo_recette", nullable = false, length = 50)
	private String photo;
	
	@Column(name="nbpers_recette", nullable = false, length = 50)
	private String nbPers;
	
	@Column(name="libelle_recette", nullable = false, length = 50)
    private String libelle;
	
	@Column(name="descriptif_recette", nullable = false, length = 1500)
    private String descriptif;
	
	
	@ManyToOne
	@JoinColumn(name = "id_categorierecette_trecette", nullable = true, foreignKey = 
	@ForeignKey(name = "FK_categorierecette_trecette"))
    private CategorieRecette categorieRecette;
    
    @ManyToMany
	@JoinTable(name = "produitRecette_recette", 
				joinColumns = @JoinColumn(name = "id_recette", referencedColumnName = "id_recette"),
				inverseJoinColumns = @JoinColumn(name = "id_produitrecette", referencedColumnName = "id_produitrecette"))
    private List<ProduitRecette> produitRecettes;
    
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

	public String getDescriptif() {
		return descriptif;
	}





	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}





	public CategorieRecette getCategorieRecette() {
		return categorieRecette;
	}

	public void setCategorieRecette(CategorieRecette categorieRecette) {
		this.categorieRecette = categorieRecette;
	}

	public List<ProduitRecette> getProduitRecettes() {
		return produitRecettes;
	}

	public void setProduitRecettes(List<ProduitRecette> produitRecettes) {
		this.produitRecettes = produitRecettes;
	}

	public Recette() {
    }

	public Recette(Integer id, String libelle, String descriptif, CategorieRecette categorieRecette) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.descriptif = descriptif;
		this.categorieRecette = categorieRecette;
	}
	

	
}