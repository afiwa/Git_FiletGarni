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
@Table(name = "produitrecette")
public class ProduitRecette implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_produitrecette", nullable = false)
	private Integer id;
	@Column(name="libelle_produitrecette", nullable = false, length=50)
	private String libelle;
	
	@Column(name="quantite_produitrecette", nullable = false, length=50)
    private String quantiteRecette;
	
    @ManyToMany(mappedBy = "produitRecettes")
    private List<Recette> recettes;
    
    @ManyToOne
    @JoinColumn(name="id_categorie_tproduitrecette", nullable=true, foreignKey=
    @ForeignKey(name="FK_id_categorie_tproduitrecette"))
    private CategorieProduit categorie;
    
    public ProduitRecette() {
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

	public String getQuantiteRecette() {
		return quantiteRecette;
	}

	public void setQuantiteRecette(String paramQuantiteRecette) {
		quantiteRecette = paramQuantiteRecette;
	}

	public List<Recette> getRecettes() {
		return recettes;
	}

	public void setRecettes(List<Recette> paramRecettes) {
		recettes = paramRecettes;
	}

	public CategorieProduit getCategorie() {
		return categorie;
	}

	public void setCategorie(CategorieProduit paramCategorie) {
		categorie = paramCategorie;
	}

	public ProduitRecette(Integer paramId, String paramLibelle, String paramQuantiteRecette,
			CategorieProduit paramCategorie) {
		super();
		id = paramId;
		libelle = paramLibelle;
		quantiteRecette = paramQuantiteRecette;
		categorie = paramCategorie;
	}

     
	
}