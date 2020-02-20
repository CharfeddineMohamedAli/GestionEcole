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
public class Note {

    private int id_note;
    private User user;

    private int notes;
    private Matiere matiere;
    private int id_classe;
    private Type_note_matiere type;

    public Note() {
    }

    public Note(int id_note, User user, int notes) {
        this.id_note = id_note;
        this.user = user;
        this.notes = notes;
    }

    public Note(int id_note, int notes) {
        this.id_note = id_note;
        this.notes = notes;
    }

    public int getId_note() {
        return id_note;
    }

    public User getUser() {
        return user;
    }

    public int getNotes() {
        return notes;
    }

    public int getId_classe() {
        return id_classe;
    }

    public void setId_note(int id_note) {
        this.id_note = id_note;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setNotes(int notes) {
        this.notes = notes;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    public void setId_classe(int id_classe) {
        this.id_classe = id_classe;
    }

    public Type_note_matiere getType() {
        return type;
    }

    public void setType(Type_note_matiere type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Note{" + "id_note=" + id_note + ", user=" + user + ", notes=" + notes + ", matiere=" + matiere + ", id_classe=" + id_classe + ", type=" + type + '}';
    }

}
