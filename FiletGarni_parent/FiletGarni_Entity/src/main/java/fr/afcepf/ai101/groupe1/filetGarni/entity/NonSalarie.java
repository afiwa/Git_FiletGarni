package fr.afcepf.ai101.groupe1.filetGarni.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@DiscriminatorValue("nonsalarie")
public class NonSalarie extends Utilisateur {

	private static final long serialVersionUID = 1L;	
	
	@Column(name="dateinscription_nonsalarie", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date dateInscription;
	
	@Column(name="datedesinscription_nonsalarie", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
    private java.util.Date dateDesinscription;
	
	@Column(name="tel1_nonsalarie", nullable = false, length = 20)
    private String tel1;	
	
	@Column(name="tel2_nonsalarie", nullable = true, length = 20)
    private String tel2;
    
    @ManyToMany
    @JoinTable(name = "adresse_nonSalarie", 
    		joinColumns = @JoinColumn(name="id_nonsalarie",  referencedColumnName = "id_utilisateur"), 
    		inverseJoinColumns = @JoinColumn(name = "id_adresse", referencedColumnName = "id_adresse"))
    private List<Adresse> adresses;
    
    public NonSalarie() {
    }

	public java.util.Date getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(java.util.Date paramDateInscription) {
		dateInscription = paramDateInscription;
	}

	public java.util.Date getDateDesinscription() {
		return dateDesinscription;
	}

	public void setDateDesinscription(java.util.Date paramDateDesinscription) {
		dateDesinscription = paramDateDesinscription;
	}

	public String getTel1() {
		return tel1;
	}

	public void setTel1(String paramTel1) {
		tel1 = paramTel1;
	}

	public String getTel2() {
		return tel2;
	}

	public void setTel2(String paramTel2) {
		tel2 = paramTel2;
	}

	public List<Adresse> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<Adresse> paramAdresses) {
		adresses = paramAdresses;
	}

	public NonSalarie(Date paramDateInscription, Date paramDateDesinscription, String paramTel1, String paramTel2) {
		super();
		dateInscription = paramDateInscription;
		dateDesinscription = paramDateDesinscription;
		tel1 = paramTel1;
		tel2 = paramTel2;
	}
}