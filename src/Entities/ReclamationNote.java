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
public class ReclamationNote extends Reclamation {

    int id_RecNote;
    Note note;
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
        super(desc, etat, user);
        this.note = note;
    }

    public ReclamationNote(int id_RecNote, String desc, User user, Note note, EtatReclamation etat) {
        super(desc, etat, user);
        this.id_RecNote = id_RecNote;
        this.note = note;
    }

    public int getId_RecNote() {
        return id_RecNote;
    }

    public Note getNote() {
        return note;
    }

    public void setId_RecNote(int id_RecNote) {
        this.id_RecNote = id_RecNote;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "ReclamationNote{" + "id_RecNote=" + id_RecNote + ", desc=" + desc + ", user=" + user + ", note=" + note + ", etat=" + etat + '}';
    }

}
