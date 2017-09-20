package fr.afcepf.ai101.filetGarni.data.api;

import fr.afcepf.ai101.groupe1.filetGarni.entity.CodePostal;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Ville;

public interface IDaoVille {

    public java.util.List<Ville> getByNom(String nom);

    public java.util.List<Ville> getByDepartement(Integer departement);

    public java.util.List<Ville> getByCodePostal(CodePostal codePostal);

}