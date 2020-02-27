package Entities;

public class ListeStage {

    //les attributs
    private int id_listeStage;
    private String sujet;
    private String description;
    private String branche;
    private String LettreMotivation;
    private String CV;
    private String adresse;

//les getters et les setters 
    public int getId_listeStage() {
        return id_listeStage;
    }

    public void setId_listeStage(int id_listeStage) {
        this.id_listeStage = id_listeStage;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBranche() {
        return branche;
    }

    public void setBranche(String branche) {
        this.branche = branche;
    }

    public String getLettreMotivation() {
        return LettreMotivation;
    }

    public void setLettreMotivation(String LettreMotivation) {
        this.LettreMotivation = LettreMotivation;
    }

    public String getCV() {
        return CV;
    }

    public void setCV(String CV) {
        this.CV = CV;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    //constructeur
    public ListeStage(int id_listeStage, String sujet, String description, String branche, String LettreMotivation, String CV, String adresse) {
        this.id_listeStage = id_listeStage;
        this.sujet = sujet;
        this.description = description;
        this.branche = branche;
        this.LettreMotivation = LettreMotivation;
        this.CV = CV;
        this.adresse = adresse;
    }

    public ListeStage() {
    }

    //toString
    @Override
    public String toString() {
        return "ListeStage{" + "id_listeStage=" + id_listeStage + ", sujet=" + sujet
                + ", description=" + description + ", branche=" + branche
                + ", LettreMotivation=" + LettreMotivation + ", CV=" + CV
                + ", adresse=" + adresse + '}';
    }

}
