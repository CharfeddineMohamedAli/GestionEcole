/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import Utils.EtatReclamation;

/**
 *
 * @author KattaX
 */
public class Reclamation {

    int id;
    String desc;
    EtatReclamation etat;
    User user;

    public Reclamation() {
        this.etat = EtatReclamation.Crée;
    }

    public Reclamation(String desc, EtatReclamation etat, User user) {
        this.desc = desc;
        this.etat = etat;
        this.user = user;
    }

    public Reclamation(int id, String desc, EtatReclamation etat, User user) {
        this.id = id;
        this.desc = desc;
        this.etat = etat;
        this.user = user;
    }

    public Reclamation(int id, String desc, User user) {
        this();
        this.id = id;
        this.desc = desc;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public EtatReclamation getEtat() {
        return etat;
    }

    public void setEtat(EtatReclamation etat) {
        this.etat = etat;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "id=" + id + ", desc=" + desc + ", etat=" + etat + ", user=" + user + '}';
    }

}
