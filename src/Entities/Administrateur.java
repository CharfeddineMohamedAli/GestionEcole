/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author admin
 */
public class Administrateur {
    private int id_admin;
    private String login;
    private String password;
    private String account_Date;

    public Administrateur() {
    }

    public Administrateur(int id_admin, String login, String password,String account_Date) {
        this.id_admin = id_admin;
        this.login = login;
        this.password = password;
        this.account_Date= account_Date;
    }

    public Administrateur(int id_admin, String login, String password) {
        this.id_admin = id_admin;
        this.login = login;
        this.password = password;
    }
    
    

    public int getId_admin() {
        return id_admin;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccount_Date() {
        return account_Date;
    }

    public void setAccount_Date(String account_Date) {
        this.account_Date = account_Date;
    }

    @Override
    public String toString() {
        return "Administrateur{" + "id_admin=" + id_admin + ", login=" + login + ", password=" + password + ", account_Date=" + account_Date + '}';
    }

    
    
    
    }


