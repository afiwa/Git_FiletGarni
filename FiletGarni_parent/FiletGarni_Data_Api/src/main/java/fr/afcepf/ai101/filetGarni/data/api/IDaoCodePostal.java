package fr.afcepf.ai101.filetGarni.data.api;

import fr.afcepf.ai101.groupe1.filetGarni.entity.CodePostal;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Ville;

public interface IDaoCodePostal {

    public java.util.List<CodePostal> getByCP(String codePostal);

    public java.util.List<CodePostal> getByDepartement(Integer departement);

    public java.util.List<CodePostal> getByVille(Ville ville);

}