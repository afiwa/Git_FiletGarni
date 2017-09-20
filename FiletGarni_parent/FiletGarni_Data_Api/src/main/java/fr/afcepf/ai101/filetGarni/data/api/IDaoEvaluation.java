package fr.afcepf.ai101.filetGarni.data.api;

public interface IDaoEvaluation {

    public void creer();

    public void supprimer();

    public void modifier();

    public void rechercher(java.util.Date dateEvaluation);

}