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
public class Classe {
    private int id_classe;
    private int num_classe;
    private int niveau;
    private int capacité;

    public Classe() {
    }

    
    public Classe(int id_classe, int num_classe, int niveau, int capacité) {
        this.id_classe = id_classe;
        this.num_classe = num_classe;
        this.niveau = niveau;
        this.capacité = capacité;
    }

    public int getId_classe() {
        return id_classe;
    }

    public int getNum_classe() {
        return num_classe;
    }

    public int getNiveau() {
        return niveau;
    }

    public int getCapacité() {
        return capacité;
    }

    public void setId_classe(int id_classe) {
        this.id_classe = id_classe;
    }

    public void setNum_classe(int num_classe) {
        this.num_classe = num_classe;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public void setCapacité(int capacité) {
        this.capacité = capacité;
    }

    @Override
    public String toString() {
        return "Classe{" + "id_classe=" + id_classe + ", num_classe=" + num_classe + ", niveau=" + niveau + ", capacit\u00e9=" + capacité + '}';
    }
    
    
      
}
