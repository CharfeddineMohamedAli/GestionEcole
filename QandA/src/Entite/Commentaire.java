/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.sql.*;

/**
 *
 * @author hp
 */
public class Commentaire {

    private int Id_Commentaire;
    private int Id_Sujet;
    private int Id_User;
    private String Contenu_Commentaire;
    private String Temps_Commentaire;

    public Commentaire() {
    }

    public Commentaire(int Id_Commentaire, int Id_Sujet, int Id_User, String Contenu_Commentaire) {
        this.Id_Commentaire = Id_Commentaire;
        this.Id_Sujet = Id_Sujet;
        this.Id_User = Id_User;
        this.Contenu_Commentaire = Contenu_Commentaire;
    }
    

    public Commentaire(int Id_Sujet, int Id_User, String Contenu_Commentaire) {
        this.Id_Sujet = Id_Sujet;
        this.Id_User = Id_User;
        this.Contenu_Commentaire = Contenu_Commentaire;
    }

    
    
    public Commentaire(int Id_Sujet, int Id_User, String Contenu_Commentaire, String Temps_Commentaire) {
        this.Id_Sujet = Id_Sujet;
        this.Id_User = Id_User;
        this.Contenu_Commentaire = Contenu_Commentaire;
        this.Temps_Commentaire = Temps_Commentaire;
    }

   

    public Commentaire(int Id_Commentaire, int Id_Sujet, int Id_User, String Contenu_Commentaire, String Temps_Commentaire) {
        this.Id_Commentaire = Id_Commentaire;
        this.Id_Sujet = Id_Sujet;
        this.Id_User = Id_User;
        this.Contenu_Commentaire = Contenu_Commentaire;
        this.Temps_Commentaire = Temps_Commentaire;
    }

    public int getId_Commentaire() {
        return Id_Commentaire;
    }

    public int getId_Sujet() {
        return Id_Sujet;
    }

    public int getId_User() {
        return Id_User;
    }

    public String getContenu_Commentaire() {
        return Contenu_Commentaire;
    }

    public String getTemps_Commentaire() {
        return Temps_Commentaire;
    }

    public void setId_Commentaire(int Id_Commentaire) {
        this.Id_Commentaire = Id_Commentaire;
    }

    public void setId_Sujet(int Id_Sujet) {
        this.Id_Sujet = Id_Sujet;
    }

    public void setId_User(int Id_User) {
        this.Id_User = Id_User;
    }

    public void setContenu_Commentaire(String Contenu_Commentaire) {
        this.Contenu_Commentaire = Contenu_Commentaire;
    }

    public void setTemps_Commentaire(String Temps_Commentaire) {
        this.Temps_Commentaire = Temps_Commentaire;
    }

    @Override
    public String toString() {
        return "Commentaire{" + "Id_Commentaire=" + Id_Commentaire + ", Id_Sujet=" + Id_Sujet + ", Id_User=" + Id_User + ", Contenu_Commentaire=" + Contenu_Commentaire + ", Temps_Commentaire=" + Temps_Commentaire + '}';
    }

}

