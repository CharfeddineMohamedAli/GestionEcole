package Entities;

public class Note {

    private int id_note;
    private float note_cc;
    private float note_ds;
    private float note_exam;
    private float moyenne;
    private float net;
    private int id_user;
    private int id_matiere;
    private int id_classe;
    private String temps_note;

    public Note(float note_cc, int id_user) {
        this.note_cc = note_cc;
        this.id_user = id_user;
    }

    public Note(int id_user, float note_ds) {
        this.note_ds = note_ds;
        this.id_user = id_user;
    }

    public Note(int id_note, int id_classe) {
        this.id_note = id_note;
        this.id_classe = id_classe;
    }

    public Note(int id_note, float note_cc, float note_ds, float note_exam, float moyenne, float net, int id_user, int id_matiere, int id_classe, String temps_note) {
        this.id_note = id_note;
        this.note_cc = note_cc;
        this.note_ds = note_ds;
        this.note_exam = note_exam;
        this.moyenne = moyenne;
        this.net = net;
        this.id_user = id_user;
        this.id_matiere = id_matiere;
        this.id_classe = id_classe;
        this.temps_note = temps_note;
    }

    public Note(int id_note, float note_cc, float note_ds, float note_examun, float moyenne, float net, int id_user, int id_matiere) {
    }

    public Note(float note_cc, float note_ds, float note_exam, int id_user, int id_matiere) {
        this.note_cc = note_cc;
        this.note_ds = note_ds;
        this.note_exam = note_exam;

        this.id_user = id_user;
        this.id_matiere = id_matiere;

    }

    public Note() {

    }

    public Note(float note_cc, float note_ds, float note_exam, int id_user) {
        this.note_cc = note_cc;
        this.note_ds = note_ds;
        this.note_exam = note_exam;
        this.id_user = id_user;
    }

    public Note(float note_cc, int id_user, int id_matiere, int id_classe) {
        this.note_cc = note_cc;
        this.id_user = id_user;
        this.id_matiere = id_matiere;
        this.id_classe = id_classe;
    }

    public int getId_note() {
        return id_note;
    }

    public void setId_note(int id_note) {
        this.id_note = id_note;
    }

    public float getNote_cc() {
        return note_cc;
    }

    public void setNote_cc(float note_cc) {
        this.note_cc = note_cc;
    }

    public float getNote_ds() {
        return note_ds;
    }

    public void setNote_ds(float note_ds) {
        this.note_ds = note_ds;
    }

    public float getNote_exam() {
        return note_exam;
    }

    public void setNote_exam(float note_exam) {
        this.note_exam = note_exam;
    }

    public float getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(float moyenne) {
        this.moyenne = moyenne;
    }

    public float getNet() {
        return net;
    }

    public void setNet(float net) {
        this.net = net;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_matiere() {
        return id_matiere;
    }

    public void setId_matiere(int id_matiere) {
        this.id_matiere = id_matiere;
    }

    public int getId_classe() {
        return id_classe;
    }

    public void setId_classe(int id_classe) {
        this.id_classe = id_classe;
    }

    public String getTemps_note() {
        return temps_note;
    }

    public void setTemps_note(String temps_note) {
        this.temps_note = temps_note;
    }

    @Override
    public String toString() {
        return "Note{" + "id_note=" + id_note + ", note_cc=" + note_cc + ", note_ds=" + note_ds + ", note_exam=" + note_exam + ", moyenne=" + moyenne + ", net=" + net + ", id_user=" + id_user + ", id_matiere=" + id_matiere + ", id_classe=" + id_classe + ", temps_note=" + temps_note + '}';
    }

}
