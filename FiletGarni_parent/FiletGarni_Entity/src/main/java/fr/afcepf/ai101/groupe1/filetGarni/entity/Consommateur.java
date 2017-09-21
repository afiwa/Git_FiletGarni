package fr.afcepf.ai101.groupe1.filetGarni.entity;

import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("consommateur")
public class Consommateur extends NonSalarie {
  
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy = "consommateur")
	private List<Commande> commandes;
    
    public Consommateur() {
    }
}