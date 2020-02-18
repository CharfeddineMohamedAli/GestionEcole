/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Vector;

/**
 *
 * @author KattaX
 */
public class Classe {

    int id_classe;
    private Vector<Enseignant> enseignants;

    public Classe() {
        enseignants = new Vector<Enseignant>();
        
    }

    public int getId_classe() {
        return id_classe;
    }

    public void setId_classe(int id_classe) {
        this.id_classe = id_classe;
    }

   
    
}
