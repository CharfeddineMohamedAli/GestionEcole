/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;


public class seance {
    private int id_seance;
    private int id_mat;
    private int heure;
    private int jour;
    private int id_user;
    private int id_salle;

    public seance() {
    }

    public seance(int id_seance) {
        this.id_seance = id_seance;
    }
    

    public seance(int id_seance, int id_mat, int id_user, int id_salle) {
        this.id_seance = id_seance;
        this.id_mat = id_mat;
        this.id_user = id_user;
        this.id_salle = id_salle;
    }
    

    public seance(int id_seance, int id_mat, int heure, int jour, int id_user, int id_salle) {
        this.id_seance = id_seance;
        this.id_mat = id_mat;
        this.heure = heure;
        this.jour = jour;
        this.id_user = id_user;
        this.id_salle = id_salle;
    }

    public int getId_seance() {
        return id_seance;
    }

    public int getId_mat() {
        return id_mat;
    }

    public int getHeure() {
        return heure;
    }

    public int getJour() {
        return jour;
    }

    public int getId_user() {
        return id_user;
    }

    public int getId_salle() {
        return id_salle;
    }

    public void setId_seance(int id_seance) {
        this.id_seance = id_seance;
    }

    public void setId_mat(int id_mat) {
        this.id_mat = id_mat;
    }

    public void setHeure(int heure) {
        this.heure = heure;
    }

    public void setJour(int jour) {
        this.jour = jour;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setId_salle(int id_salle) {
        this.id_salle = id_salle;
    }
     
}
