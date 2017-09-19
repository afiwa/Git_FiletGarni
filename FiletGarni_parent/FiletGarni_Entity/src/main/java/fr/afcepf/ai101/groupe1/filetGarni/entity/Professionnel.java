package fr.afcepf.ai101.groupe1.filetGarni.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
@Entity
@DiscriminatorValue("professionnel")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_professionnel")
public class Professionnel extends NonSalarie {

	private static final long serialVersionUID = 1L;

	@Column(name="identifiant_professionnel",nullable=true, length=50)
	private String identifiantConnexion;

	@Column(name="raisonsociale_professionnel",nullable=true, length=150)
    private String raisonSociale;

	@Column(name="siret_professionnel",nullable=true, length=20)
    private String siret;

	@Column(name="iban_professionnel",nullable=true, length=50)
    private String iban;

	@Column(name="bic_professionnel",nullable=true, length=20)
    private String bic;
    
    public String getIdentifiantConnexion() {
		return identifiantConnexion;
	}

	public void setIdentifiantConnexion(String identifiantConnexion) {
		this.identifiantConnexion = identifiantConnexion;
	}

	public String getRaisonSociale() {
		return raisonSociale;
	}

	public void setRaisonSociale(String raisonSociale) {
		this.raisonSociale = raisonSociale;
	}

	public String getSiret() {
		return siret;
	}

	public void setSiret(String siret) {
		this.siret = siret;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getBic() {
		return bic;
	}

	public void setBic(String bic) {
		this.bic = bic;
	}

	public Professionnel() {
    }

	public Professionnel(String paramIdentifiantConnexion, String paramRaisonSociale, String paramSiret,
			String paramIban, String paramBic) {
		super();
		identifiantConnexion = paramIdentifiantConnexion;
		raisonSociale = paramRaisonSociale;
		siret = paramSiret;
		iban = paramIban;
		bic = paramBic;
	}

	
    
    

}