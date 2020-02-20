/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author KattaX
 */
public class Enseignant extends User {

    int type = 0;
    int id_classe;
    String classe;

    public Enseignant() {
        super();
    }

    public Enseignant(int id_user, String first_Name, String last_Name, String user_Name, String classe, String password, String email, int phone_number, String gender, int CIN, String account_Date, String Image_user, int age, int id_classe, int type) {
        super(id_user, first_Name, last_Name, user_Name, classe, password, email, phone_number, gender, CIN, account_Date, Image_user, age);
        this.type = 0;
        this.id_classe = id_classe;
        this.classe = classe;
    }

    public Enseignant(int id_user, String first_Name, String last_Name, String email, int id_classe, int type) {
        super(id_user, first_Name, last_Name, email);
        this.type = 0;
        this.id_classe = id_classe;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getId_classe() {
        return id_classe;
    }

    public void setId_classe(int id_classe) {
        this.id_classe = id_classe;
    }

    @Override
    public String toString() {
        return super.toString() + " Enseignant{" + "type=" + type + ", id_classe=" + id_classe + '}';
    }

}
