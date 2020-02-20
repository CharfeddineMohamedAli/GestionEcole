/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;

/**
 *
 * @author admin
 */
public class Parent extends User {

    public Parent() {
        super();

    }

    public Parent(int id_user, String first_Name, String last_Name, String user_Name, String password, String email, int phone_number, String gender, int CIN, String account_Date, String Image_user, int age, String classe, String usernameCanonical, String emailCanonical, Boolean enabled, String salt, String plainPassword, Date lastLogin, String role) {
        super(id_user, first_Name, last_Name, user_Name, password, email, phone_number, gender, CIN, account_Date, Image_user, age, classe, usernameCanonical, emailCanonical, enabled, salt, plainPassword, lastLogin, role);

    }

    @Override
    public String toString() {
        return "Parent{" + super.toString() + '}';
    }

}
