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
@Table(name = "categorierecette")
public class CategorieRecette implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_categorierecette", nullable = false)
	private Integer id;
	
	@Column(name="libelle_categorierecette", nullable = false, length = 50)
    private String libelle;
	
	@OneToMany(mappedBy = "categorieRecette")
	private List<Recette> recettes;

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

	public List<Recette> getRecettes() {
		return recettes;
	}

	public void setRecettes(List<Recette> recettes) {
		this.recettes = recettes;
	}

	public CategorieRecette(Integer id, String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}
    
    
}