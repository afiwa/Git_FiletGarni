package fr.afcepf.ai101.groupe1.filetGarni.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="utilisateur")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_utilisateur")
public class Utilisateur implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_utilisateur", nullable = false)
	private Integer id;
	
	@Column(name="nom_utilisateur", nullable = false, length = 50)
    private String nom;
	
	@Column(name="prenom_utilisateur", nullable = false, length = 50)
    private String prenom;
	
	@Column(name="mail_utilisateur", nullable = false, length = 150)
    private String mail;
	
	@Column(name="mdp_utilisateur", nullable = false, length = 50)
    private String mdp;
    
    public Utilisateur() {
    }

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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public Utilisateur(Integer paramId, String paramNom, String paramPrenom, String paramMail, String paramMdp) {
		super();
		id = paramId;
		nom = paramNom;
		prenom = paramPrenom;
		mail = paramMail;
		mdp = paramMdp;
	}
}