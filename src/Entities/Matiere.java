/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author nada kd
 */
public class Matiere {

    private int id_mat;
    private String nom_mat;
    private int coef;

    public Matiere(int id_mat, String nom_mat, int coef) {
        this.id_mat = id_mat;
        this.nom_mat = nom_mat;
        this.coef = coef;

    }

    public int getId_mat() {
        return id_mat;
    }

    public String getNom_mat() {
        return nom_mat;
    }

    public int getCoef() {
        return coef;
    }

    public void setId_mat(int id_mat) {
        this.id_mat = id_mat;
    }

    public void setNom_mat(String nom_mat) {
        this.nom_mat = nom_mat;
    }

    public void setCoef(int coef) {
        this.coef = coef;
    }

    @Override
    public String toString() {
        return "Matiere{" + "id_mat=" + id_mat + ", nom_mat=" + nom_mat + ", coef=" + coef + '}';
    }

}
