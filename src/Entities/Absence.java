/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author HPAY104-I5-1TR
 */
public class Absence {

    private int id_absence;
    private int id_user;
    private int id_seance;
    private int absence;
    private String dateabs;
    private int id_mat;
    private int id_classe;

    public Absence() {
    }

    public Absence(int id_absence, int id_user, int id_seance, int absence, String dateabs, int id_mat, int id_classe) {
        this.id_absence = id_absence;
        this.id_user = id_user;
        this.id_seance = id_seance;
        this.absence = absence;
        this.dateabs = dateabs;
        this.id_mat = id_mat;
        this.id_classe = id_classe;
    }

    public Absence(int id_user, int absence) {
        this.id_user = id_user;
        this.absence = absence;
    }

    public Absence(int id_absence) {
        this.id_absence = id_absence;
    }

    /*
    public Absence(int absence) {
        this.absence = absence;
    }
    
     */

    public Absence(int id_absence, int id_user, int id_seance, int absence, String dateabs) {
        this.id_absence = id_absence;
        this.id_user = id_user;
        this.id_seance = id_seance;
        this.absence = absence;
        this.dateabs = dateabs;
    }

    /*public Absence(int id_absence, int id_user, int id_seance, int absence, String dateabs) {
        this.id_absence = id_absence;
        this.id_user = id_user;
        this.id_seance = id_seance;
        
        this.dateabs = dateabs;
    }*/
    public int isAbsence() {
        return absence;
    }

    public void setAbsence(int absence) {
        this.absence = absence;
    }

    public int getId_absence() {
        return id_absence;
    }

    public int getId_user() {
        return id_user;
    }

    public int getAbsence() {
        return absence;
    }

    public String getDateabs() {
        return dateabs;
    }

    public void setId_absence(int id_absence) {
        this.id_absence = id_absence;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setDateabs(String dateabs) {
        this.dateabs = dateabs;
    }

    public int getId_seance() {
        return id_seance;
    }

    public void setId_seance(int id_seance) {
        this.id_seance = id_seance;
    }

    public Absence(int id_user, int id_seance, int absence, String dateabs, int id_mat) {
        this.id_user = id_user;
        this.id_seance = id_seance;
        this.absence = absence;
        this.dateabs = dateabs;
        this.id_mat = id_mat;
    }

    public int getId_classe() {
        return id_classe;
    }

    public void setId_classe(int id_classe) {
        this.id_classe = id_classe;
    }

    public Absence(int id_user, int absence, int id_mat, int id_classe) {
        this.id_user = id_user;
        this.absence = absence;
        this.id_mat = id_mat;
        this.id_classe = id_classe;
    }

    public Absence(int id_absence, int id_user, int id_seance, int absence, String dateabs, int id_mat) {
        this.id_absence = id_absence;
        this.id_user = id_user;
        this.id_seance = id_seance;
        this.absence = absence;
        this.dateabs = dateabs;
        this.id_mat = id_mat;
    }

    public int getId_mat() {
        return id_mat;
    }

    public void setId_mat(int id_mat) {
        this.id_mat = id_mat;
    }

    @Override
    public String toString() {
        return "Absence{" + "id_absence=" + id_absence + ", id_user=" + id_user + ", id_seance=" + id_seance + ", absence=" + absence + ", dateabs=" + dateabs + ", id_mat=" + id_mat + ", id_classe=" + id_classe + '}';
    }

}
