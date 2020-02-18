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

public class Etudiant extends User {
    int type = 1;
    public int id_classe;

    public Etudiant() {
        super();
    }

    public Etudiant( int id_user, String first_Name, String last_Name, String user_Name, String password, String email, int phone_number, String gender, int CIN, String account_Date, String Image_user, int age,int id_classe,int type) {
        super(id_user, first_Name, last_Name, user_Name, password, email, phone_number, gender, CIN, account_Date, Image_user, age);
        this.id_classe = id_classe;
        this.type=1;
    }

    public int getId_classe() {
        return id_classe;
    }

    public void setId_classe(int id_classe) {
        this.id_classe = id_classe;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Etudiant{" + "type=" + type + ", id_classe=" + id_classe + '}';
    }
    
    
}
