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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "recette")
public class Recette implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_recette", nullable = false)
	private Integer id;
	
	@Column(name="libelle_recette", nullable = false, length = 50)
    private String libelle;
	
	@Column(name="descriptif_recette", nullable = false, length = 500)
    private String descriptif;
	
	
	@OneToMany(mappedBy = "recette")
    private List<CategorieRecette> categorieRecettes;
    
    @ManyToMany
	@JoinTable(name = "produitRecette_recette", 
				joinColumns = @JoinColumn(name = "id_recette", referencedColumnName = "id_recette"),
				inverseJoinColumns = @JoinColumn(name = "id_produitrecette", referencedColumnName = "id_produitrecette"))
    private List<ProduitRecette> produitRecettes;
    
    public Recette() {
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer paramId) {
		id = paramId;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String paramLibelle) {
		libelle = paramLibelle;
	}

	public String getDescriptif() {
		return descriptif;
	}

	public void setDescriptif(String paramDescriptif) {
		descriptif = paramDescriptif;
	}

	public List<CategorieRecette> getCategorieRecettes() {
		return categorieRecettes;
	}

	public void setCategorieRecettes(List<CategorieRecette> paramCategorieRecettes) {
		categorieRecettes = paramCategorieRecettes;
	}

	public List<ProduitRecette> getProduitRecettes() {
		return produitRecettes;
	}

	public void setProduitRecettes(List<ProduitRecette> paramProduitRecettes) {
		produitRecettes = paramProduitRecettes;
	}

	public Recette(Integer paramId, String paramLibelle, String paramDescriptif) {
		super();
		id = paramId;
		libelle = paramLibelle;
		descriptif = paramDescriptif;
	}    
}