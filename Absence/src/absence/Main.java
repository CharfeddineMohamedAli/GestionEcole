/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package absence;

import Entite.Absence;
import Service.ServiceAbsence;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author HPAY104-I5-1TR
 */
public class Main {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) throws SQLException {
        Absence absence=new Absence();
        ServiceAbsence serviceAbsence=new ServiceAbsence();
        Absence ajoutab=new Absence(1,1,1);
        Absence suppab=new Absence(16);
        Absence modifab =new Absence(15,15,15,15);


        //ajout
                //serviceAbsence.ajouterAbsence(ajoutab);
        //supp

              // serviceAbsence.supprimerAbsence(suppab);
        //modifier 
             //serviceAbsence.modifierAbsence(modifab);


        // findbyiduser    
                Absence ab=new Absence(4,4,4,4);

     //List<Absence> y= serviceAbsence.FindAbsenceByIdUser(ab.getId_user());
    //System.out.println(y);
        System.out.println("read all ");
        //read
      //  serviceAbsence.readAllS();
                System.out.println("trie ");

                
                //trie
    //List<Absence> trieAbs = serviceAbsence.TrierParDateAbsence();
    //System.out.println(trieAbs);
    
    
    
    //getabsbymat
    
    System.out.println("get absence par matiere ");
    List<Absence> AbsMatiere = serviceAbsence.getabsenceByIdmatiere(3);
    System.out.println(AbsMatiere);
        
    }
    
}
