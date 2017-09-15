package fr.afcepf.ai101.groupe1.filetGarni.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("salarie")
public class Salarie extends Utilisateur {

	private static final long serialVersionUID = 1L;
	
	@Column(name="identifiant_salarie", nullable = false, length = 50)
	private String identifiantConnexion;
    
    public Salarie() {
    }

	public String getIdentifiantConnexion() {
		return identifiantConnexion;
	}

	public void setIdentifiantConnexion(String identifiantConnexion) {
		this.identifiantConnexion = identifiantConnexion;
	}

	public Salarie(String paramIdentifiantConnexion) {
		super();
		identifiantConnexion = paramIdentifiantConnexion;
	}
}