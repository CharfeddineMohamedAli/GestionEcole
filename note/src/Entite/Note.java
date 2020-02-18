package Entite;

import Entite.Type;
import java.util.logging.Logger;


public class Note {
    private int id_note;
    private int id_user;
    private int notes;
    private int id_mat;
    private int id_classe;
    private Type type;
    private String temps_note;

    public Note(int id_user, int notes, Type type) {
        this.id_user = id_user;
        this.notes = notes;
        this.type = type;
    }
    

    public Note(int id_user, int notes, int id_mat, Type type) {                             //ajouter
        this.id_user = id_user;
        this.notes = notes;
        this.id_mat = id_mat;
        this.type = type;
    }         
     public Note(int id_note,int id_user, int notes, int id_mat, Type type) {               //modifier
        this.id_note = id_note;
        this.id_user = id_user;
        this.notes = notes;
        this.id_mat = id_mat;
        this.type = type;
    }        
    public Note(int id_note, int id_user, int notes, int id_mat, int id_classe, String temps_note, Type type) {          //consulter
        this.id_note = id_note;
        this.id_user = id_user;
        this.notes = notes;
        this.id_mat = id_mat;
        this.id_classe = id_classe;
        this.temps_note = temps_note;
             this.type = type;
    }
    
    public Note(int id_note, int notes) {                           //FindnomByUser        
        this.id_note=id_note;
        this.notes = notes;
    }                                               
   
    public Note(int id_note, int id_user, int notes) {
        this.id_note = id_note;
        this.id_user = id_user;
        this.notes = notes;
    }
    

    public Note( int id_user, int notes, int id_mat, int id_classe) {
       
        this.id_user = id_user;
        this.notes = notes;
        this.id_mat = id_mat;
        this.id_classe = id_classe;
   
    }


  
    


  

   
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
    

    public Note(int id_note) {
        this.id_note = id_note;
    }
    
    

   

    

    public int getId_note() {
        return id_note;
    }

    public int getId_user() {
        return id_user;
    }

    public int getNotes() {
        return notes;
    }

    

    public void setId_note(int id_note) {
        this.id_note = id_note;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setNotes(int notes) {
        this.notes = notes;
    }


    public String getTemps_note() {
        return temps_note;
    }
    
     public void setTemps_note(String temps_note) {
        this.temps_note = temps_note;
    }

    public int getId_mat() {
        return id_mat;
    }

    public int getId_classe() {
        return id_classe;
    }

    public void setId_mat(int id_mat) {
        this.id_mat = id_mat;
    }

    public void setId_classe(int id_classe) {
        this.id_classe = id_classe;
    }

  

    @Override
    public String toString() {
        return "Note{" + "id_note=" + id_note + ", id_user=" + id_user + ", notes=" + notes + ", id_mat=" + id_mat + ", id_classe=" + id_classe + ", type=" + type + ", temps_note=" + temps_note + '}';
    }
 
    
    
}
