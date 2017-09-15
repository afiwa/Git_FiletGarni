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
@Table(name = "typepaiement")
public class TypePaiement implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_typepaiement", nullable = false)
	private Integer id;
	
	@Column(name="libelle_typepaiement", nullable = false, length = 50)
    private String libelle;
	
	@OneToMany(mappedBy = "typePaiement")
    private List<Commande> commandes;
    
    public TypePaiement() {
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

	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> paramCommandes) {
		commandes = paramCommandes;
	}

	public TypePaiement(Integer paramId, String paramLibelle) {
		super();
		id = paramId;
		libelle = paramLibelle;
	}   
}