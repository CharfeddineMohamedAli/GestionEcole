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
public class ReclamationNote {

    int id_RecNote;
    String desc;
    User user;
    Note note;
    EtatReclamation etat;
    int id_note;

    public void setId_note(int id_note) {
        this.id_note = id_note;
    }

    public int getId_note() {
        return id_note;
    }

    public ReclamationNote() {
    }

    public ReclamationNote(String desc, User user, Note note, EtatReclamation etat) {
        this.desc = desc;
        this.user = user;
        this.note = note;
        this.etat = etat;
    }

    public ReclamationNote(int id_RecNote, String desc, User user, Note note, EtatReclamation etat) {
        this.id_RecNote = id_RecNote;
        this.desc = desc;
        this.user = user;
        this.note = note;
        this.etat = etat;
    }

    public int getId_RecNote() {
        return id_RecNote;
    }

    public String getDesc() {
        return desc;
    }

    public User getUser() {
        return user;
    }

    public Note getNote() {
        return note;
    }

    public EtatReclamation getEtat() {
        return etat;
    }

    public void setId_RecNote(int id_RecNote) {
        this.id_RecNote = id_RecNote;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public void setEtat(EtatReclamation etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "ReclamationNote{" + "id_RecNote=" + id_RecNote + ", desc=" + desc + ", user=" + user + ", note=" + note + ", etat=" + etat + '}';
    }

}
