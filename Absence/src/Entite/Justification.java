/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

/**
 *
 * @author HPAY104-I5-1TR
 */
public class Justification {
    int id_user;
    int id_absence;
    int valeur;

    public Justification(int id_user, int id_absence, int valeur) {
        this.id_user = id_user;
        this.id_absence = id_absence;
        this.valeur = valeur;
    }

    public Justification(int id_absence, int valeur) {
        this.id_absence = id_absence;
        this.valeur = valeur;
    }

    public int getId_user() {
        return id_user;
    }

    public int getId_absence() {
        return id_absence;
    }

    public int getValeur() {
        return valeur;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setId_absence(int id_absence) {
        this.id_absence = id_absence;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }
    
    
}
