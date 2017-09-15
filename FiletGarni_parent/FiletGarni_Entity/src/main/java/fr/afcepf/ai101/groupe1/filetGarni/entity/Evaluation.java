package fr.afcepf.ai101.groupe1.filetGarni.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "evaluation")
public class Evaluation implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_evaluation", nullable = false)
	private Integer id;
	
	@Column(name="note_produits_evaluation", nullable = true)
    private Integer noteProduits;
	
	@Column(name="note_livraison_evaluation", nullable = true)
    private Integer noteLivraison;
	
	@Column(name="date_evaluation", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
    private java.util.Date dateEvaluation;
	
	@Column(name="commentaire_evaluation", nullable = true, length = 500)
    private String commentaire;
	
	@OneToOne(mappedBy = "evaluation")
    private Commande commande;
    
    public Evaluation() {
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer paramId) {
		id = paramId;
	}

	public Integer getNoteProduits() {
		return noteProduits;
	}

	public void setNoteProduits(Integer paramNoteProduits) {
		noteProduits = paramNoteProduits;
	}

	public Integer getNoteLivraison() {
		return noteLivraison;
	}

	public void setNoteLivraison(Integer paramNoteLivraison) {
		noteLivraison = paramNoteLivraison;
	}

	public java.util.Date getDateEvaluation() {
		return dateEvaluation;
	}

	public void setDateEvaluation(java.util.Date paramDateEvaluation) {
		dateEvaluation = paramDateEvaluation;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String paramCommentaire) {
		commentaire = paramCommentaire;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande paramCommande) {
		commande = paramCommande;
	}

	public Evaluation(Integer paramId, Integer paramNoteProduits, Integer paramNoteLivraison, Date paramDateEvaluation,
			String paramCommentaire, Commande paramCommande) {
		super();
		id = paramId;
		noteProduits = paramNoteProduits;
		noteLivraison = paramNoteLivraison;
		dateEvaluation = paramDateEvaluation;
		commentaire = paramCommentaire;
		commande = paramCommande;
	}      
}