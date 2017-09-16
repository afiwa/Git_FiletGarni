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
@Table(name = "categorierecette")
public class CategorieRecette implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_categorierecette", nullable = false)
	private Integer id;
	
	@Column(name="libelle_categorierecette", nullable = false, length = 50)
    private String libelle;
	
	@ManyToOne
	@JoinColumn(name = "id_recette_tcategorierecette", nullable = true, 
				foreignKey = @ForeignKey(name = "FK_recette_tcategorierecette"))
    private Recette recette;
    
    public CategorieRecette() {
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

	public Recette getRecette() {
		return recette;
	}

	public void setRecette(Recette paramRecette) {
		recette = paramRecette;
	}

	public CategorieRecette(Integer paramId, String paramLibelle, Recette paramRecette) {
		super();
		id = paramId;
		libelle = paramLibelle;
		recette = paramRecette;
	}

}