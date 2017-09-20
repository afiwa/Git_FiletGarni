package fr.afcepf.ai101.filetGarni.data.api;

import fr.afcepf.ai101.groupe1.filetGarni.entity.PeriodeDAbsence;

public interface IDaoPeriodeDAbsence {

    public void creer();

    public void modifier();

    public void supprimer();

    public java.util.List<PeriodeDAbsence> getByUtilisateur(Integer id_utilisateur);

}