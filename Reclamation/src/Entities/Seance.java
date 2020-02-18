/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import Utils.HeureSeance;
import Utils.JourSeance;

/**
 *
 * @author KattaX
 */
public class Seance {

    private int id;
    private HeureSeance heureSeance;
    private JourSeance jourSeance;
    private Classe classe;
    private Module module;
    private Enseignant enseignant;
    private String semaine;
    private Salle salle;

    public Seance() {
        classe = new Classe();
    }

    public Seance(HeureSeance heureSeance, JourSeance jourSeance, Classe classe, Module module, Enseignant enseignant, String semaine, Salle salle) {
        this.heureSeance = heureSeance;
        this.jourSeance = jourSeance;
        this.classe = classe;
        this.module = module;
        this.enseignant = enseignant;
        this.semaine = semaine;
        this.salle = salle;
    }
}
