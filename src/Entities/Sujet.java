/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.*;
import java.text.SimpleDateFormat;

/**
 *
 * @author
 */
public class Sujet {

    private int Id_Sujet;
    private int Id_User;
    private String Titre_Sujet;
    private String Contenu_Sujet;
    private String Temps_Sujet;
    private int nbre_vues;
    private int nbre_jaime;
    private Categorie categorie;
    private int etat;

    public Sujet() {
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public Sujet(int Id_User, String Titre_Sujet, String Contenu_Sujet, String Temps_Sujet, int nbre_vues, int nbre_jaime, Categorie categorie, int etat) {
        this.Id_User = Id_User;
        this.Titre_Sujet = Titre_Sujet;
        this.Contenu_Sujet = Contenu_Sujet;
        this.Temps_Sujet = Temps_Sujet;
        this.nbre_vues = nbre_vues;
        this.nbre_jaime = nbre_jaime;
        this.categorie = categorie;
        this.etat = etat;
    }

    public Sujet(int Id_Sujet, int Id_User, String Titre_Sujet, String Contenu_Sujet, String Temps_Sujet, int nbre_vues, int nbre_jaime, Categorie categorie, int etat) {
        this.Id_Sujet = Id_Sujet;
        this.Id_User = Id_User;
        this.Titre_Sujet = Titre_Sujet;
        this.Contenu_Sujet = Contenu_Sujet;
        this.Temps_Sujet = Temps_Sujet;
        this.nbre_vues = nbre_vues;
        this.nbre_jaime = nbre_jaime;
        this.categorie = categorie;
        this.etat = etat;
    }

    public Sujet(int Id_Sujet, int Id_User, String Titre_Sujet, String Contenu_Sujet, String Temps_Sujet, int nbre_vues, int nbre_jaime, Categorie categorie) {
        this.Id_Sujet = Id_Sujet;
        this.Id_User = Id_User;
        this.Titre_Sujet = Titre_Sujet;
        this.Contenu_Sujet = Contenu_Sujet;
        this.Temps_Sujet = Temps_Sujet;
        this.nbre_vues = nbre_vues;
        this.nbre_jaime = nbre_jaime;
        this.categorie = categorie;
    }

    public Sujet(int Id_Sujet, int Id_User, String Titre_Sujet, String Contenu_Sujet, int nbre_vues, int nbre_jaime, Categorie categorie) {
        this.Id_Sujet = Id_Sujet;
        this.Id_User = Id_User;
        this.Titre_Sujet = Titre_Sujet;
        this.Contenu_Sujet = Contenu_Sujet;

        this.nbre_vues = nbre_vues;
        this.nbre_jaime = nbre_jaime;
        this.categorie = categorie;
    }

    public Sujet(int Id_Sujet, int Id_User, String Titre_Sujet, String Contenu_Sujet, Categorie categorie) {
        this.Id_Sujet = Id_Sujet;
        this.Id_User = Id_User;
        this.Titre_Sujet = Titre_Sujet;
        this.Contenu_Sujet = Contenu_Sujet;
        this.categorie = categorie;
    }

    public Sujet(int Id_Sujet, int Id_User, String Titre_Sujet, String Contenu_Sujet) {
        this.Id_Sujet = Id_Sujet;
        this.Id_User = Id_User;
        this.Titre_Sujet = Titre_Sujet;
        this.Contenu_Sujet = Contenu_Sujet;
    }

    public Sujet(int Id_User, String Titre_Sujet, String Contenu_Sujet, Categorie categorie) {
        this.Id_User = Id_User;
        this.Titre_Sujet = Titre_Sujet;
        this.Contenu_Sujet = Contenu_Sujet;
        this.categorie = categorie;
    }

    public Sujet(int Id_Sujet, int Id_User) {
        this.Id_Sujet = Id_Sujet;
        this.Id_User = Id_User;

    }

    public Sujet(int Id_Sujet, int Id_User, String Titre_Sujet, String Contenu_Sujet, String Temps_Sujet, Categorie categorie) {
        this.Id_Sujet = Id_Sujet;
        this.Id_User = Id_User;
        this.Titre_Sujet = Titre_Sujet;
        this.Contenu_Sujet = Contenu_Sujet;
        this.Temps_Sujet = Temps_Sujet;

        this.categorie = categorie;
    }

    public Sujet(int aInt, int aInt0, String string, String string0, String string1, int aInt1, Categorie valueOf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_Sujet() {
        return Id_Sujet;
    }

    public void setId_Sujet(int Id_Sujet) {
        this.Id_Sujet = Id_Sujet;
    }

    public int getId_User() {
        return Id_User;
    }

    public void setId_User(int Id_User) {
        this.Id_User = Id_User;
    }

    public String getTitre_Sujet() {
        return Titre_Sujet;
    }

    public void setTitre_Sujet(String Titre_Sujet) {
        this.Titre_Sujet = Titre_Sujet;
    }

    public String getContenu_Sujet() {
        return Contenu_Sujet;
    }

    public void setContenu_Sujet(String Contenu_Sujet) {
        this.Contenu_Sujet = Contenu_Sujet;
    }

    public String getTemps_Sujet() {
        return Temps_Sujet;
    }

    public void setTemps_Sujet(String Temps_Sujet) {
        this.Temps_Sujet = Temps_Sujet;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public int getNbre_vues() {
        return nbre_vues;
    }

    public void setNbre_vues(int nbre_vues) {
        this.nbre_vues = nbre_vues;
    }

    public int getNbre_jaime() {
        return nbre_jaime;
    }

    public void setNbre_jaime(int nbre_jaime) {
        this.nbre_jaime = nbre_jaime;
    }

    @Override
    public String toString() {
        return "Sujet{" + "Id_Sujet=" + Id_Sujet + ", Id_User=" + Id_User + ", Titre_Sujet=" + Titre_Sujet + ", Contenu_Sujet=" + Contenu_Sujet + ", Temps_Sujet=" + Temps_Sujet + ", nbre_vues=" + nbre_vues + ", nbre_jaime=" + nbre_jaime + ", categorie=" + categorie + '}';
    }

    public void getId_Sujet(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
