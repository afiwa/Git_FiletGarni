package fr.afcepf.ai101.filetGarni.business.impl;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.ai101.filetGarni.business.api.IBusinessAdministrateur;
import fr.afcepf.ai101.filetGarni.data.api.IDaoSalarie;
import fr.afcepf.ai101.filetGarni.data.api.IDaoUtilisateur;

@Remote(IBusinessAdministrateur.class)
@Stateless
public class BusinessAdministrateur implements IBusinessAdministrateur {

    public BusinessAdministrateur() {
    }

    @EJB
    private IDaoSalarie daoSalarie;

    @EJB
    private IDaoUtilisateur daoUtilisateur;

}