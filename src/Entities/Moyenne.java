/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

public class Moyenne {

    private int id_moy;
    private int id_mat;
    private int id_note;

    public Moyenne(int id_moy, int id_mat, int id_note) {
        this.id_moy = id_moy;
        this.id_mat = id_mat;
        this.id_note = id_note;
    }

    public int getId_moy() {
        return id_moy;
    }

    public int getId_mat() {
        return id_mat;
    }

    public int getId_note() {
        return id_note;
    }

    public void setId_moy(int id_moy) {
        this.id_moy = id_moy;
    }

    public void setId_mat(int id_mat) {
        this.id_mat = id_mat;
    }

    public void setId_note(int id_note) {
        this.id_note = id_note;
    }

    @Override
    public String toString() {
        return "Moyenne{" + "id_moy=" + id_moy + ", id_mat=" + id_mat + ", id_note=" + id_note + '}';
    }

}
