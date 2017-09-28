package fr.afcepf.ai101.groupe1.filetgarni.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;
import javax.faces.convert.DateTimeConverter;
import javax.faces.convert.FacesConverter;

import fr.afcepf.ai101.filetGarni.business.api.IBusinessPointRelais;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Commande;
import fr.afcepf.ai101.groupe1.filetGarni.entity.PointRelais;
@SessionScoped
@ManagedBean(name="mbPointRelais")
public class ManagedBeanPointRelais implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private IBusinessPointRelais buPR;
	private List<Commande> listCommandePR;
	private PointRelais PR;

	public void initPR(){
		PR = buPR.getPointRelaisByID(67);
	}
	@PostConstruct
	public void init() {
		initPR();
		afficherCommandePointRelais(PR);
	}
	public void afficherCommandePointRelais(PointRelais pointrelais){
		listCommandePR = buPR.afficherCommandesLivrees(PR);

	
	}
	@FacesConverter("myDateTimeConverter")
	public class MyDateTimeConverter extends DateTimeConverter {

	    public MyDateTimeConverter() {
	        setPattern("MM/dd/yyyy");
	    }

	    @Override
	    public Object getAsObject(FacesContext context, UIComponent component, String value) {
	        if (value != null && value.length() != getPattern().length()) {
	            throw new ConverterException("Invalid format");
	        }

	        return super.getAsObject(context, component, value);
	    }

	}
	public IBusinessPointRelais getBuPR() {
		return buPR;
	}
	public void setBuPR(IBusinessPointRelais buPR) {
		this.buPR = buPR;
	}
	public List<Commande> getListCommandePR() {
		return listCommandePR;
	}
	public void setListCommandePR(List<Commande> listCommandePR) {
		this.listCommandePR = listCommandePR;
	}
	public PointRelais getPR() {
		return PR;
	}
	public void setPR(PointRelais pR) {
		PR = pR;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
