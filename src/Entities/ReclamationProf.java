
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
public class ReclamationProf extends Reclamation{

    int id_RecProf;
    Enseignant prof;

    public ReclamationProf() {
    }

    public ReclamationProf(User user, String desc, EtatReclamation etat, Enseignant prof) {
        this.user = user;
        this.desc = desc;
        this.etat = etat;
        this.prof = prof;
    }

    public ReclamationProf(int id_RecProf, User user, String desc, EtatReclamation etat, Enseignant prof) {
        this.id_RecProf = id_RecProf;
        this.user = user;
        this.desc = desc;
        this.etat = etat;
        this.prof = prof;
    }

    public int getId_RecProf() {
        return id_RecProf;
    }

    public Enseignant getProf() {
        return prof;
    }

    public void setId_RecProf(int id_RecProf) {
        this.id_RecProf = id_RecProf;
    }

    public void setProf(Enseignant prof) {
        this.prof = prof;
    }

    @Override
    public String toString() {
        return "ReclamationProf{" + "id_RecProf=" + id_RecProf + ", user=" + user + ", desc=" + desc + ", etat=" + etat + ", prof=" + prof + '}';
    }
    
}
