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
public class ClasseEnseignant {

    private int id_classe;
    private int id_enseignant;

    public ClasseEnseignant() {
    }

    public ClasseEnseignant(int id_classe, int id_enseignant) {
        this.id_classe = id_classe;
        this.id_enseignant = id_enseignant;
    }

    public int getId_classe() {
        return id_classe;
    }

    public void setId_classe(int id_classe) {
        this.id_classe = id_classe;
    }

    public int getId_enseignant() {
        return id_enseignant;
    }

    public void setId_enseignant(int id_enseignant) {
        this.id_enseignant = id_enseignant;
    }
    

}
