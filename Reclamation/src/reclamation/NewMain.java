/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reclamation;

import Entities.Enseignant;
import Entities.Note;
import Entities.Reclamation;
import Entities.ReclamationNote;
import Entities.ReclamationProf;
import Entities.User;
import Services.ReclamationService;
import Utils.EtatReclamation;
import java.sql.SQLException;

/**
 *
 * @author KattaX
 */
public class NewMain {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        
        User u = new User(10, "Mohamed", "Kattax", "mohamed.kattax@esprit.tn");
        Note n=new Note(1,u,4);
        ReclamationService reclamationservice = new ReclamationService();
        ReclamationNote reclamationNote=new ReclamationNote("go", u , n,EtatReclamation.Crée);
        Enseignant e=new Enseignant(20, "Mohamed", "Kattax", "mohamed.kattax@esprit.tn",0,1);
        ReclamationProf reclamationProf=new ReclamationProf(u ,"goo", EtatReclamation.Crée,e);

        //Reclamation reclamation = new Reclamation("graaave", EtatReclamation.Crée, u);
        //reclamation.setId(2);

                                /*   ajouter reclamation
           reclamationservice.ajouterReclamation(reclamatreclamationion);
         */
                               /*   ajouter reclamation Note
           reclamationservice.ajouterReclamationNote(reclamationNote);*/
                                                                
                                /*   ajouter reclamation Prof 
           reclamationservice.ajouterReclamationProf(reclamationProf); */
                                
                                /*  modifier reclamation Note 
                                reclamationNote.setId_RecNote(1);
                   reclamationservice.modifierReclamationNote(reclamationNote); */
                            
                                /*  modifier reclamation Prof  
                                reclamationProf.setId_RecProf(2);
                   reclamationservice.modifierReclamationProf(reclamationProf);*/
                               
                                
         
                                
                                  /* supprimer reclamation
           reclamation.setId(1);
           reclamationservice.suprimerReclamation(reclamation);
         */
                                /* afficher tous les reclamations
        reclamationservice.getAll();
         */
                                /*modififier reclamation
         reclamation.setId(4);
        reclamationservice.modifierReclamation(reclamation);
        
         */
                                 /* afficher reclamation par id user
        reclamationservice.getAllParUserID(6);
         */
                                 
                                 
                                 
                                 
                                 
                                 
                                 
                                 /* rechercher reclamation par id_reclamation
        reclamationservice.rechercherReclamationParID(5);
         */
                                /* afficher liste enseignants par classe      
        for (User user :reclamationservice.getListEnseignantsClasse(2)){
            System.out.println(user);
        };

         */
                                /*afficher note par user et matiere 
        
        
               reclamationservice.getNoteParUserID(1, 1);
         */
                                /* nb Reclamations Total
        
        
               reclamationservice.nbReclamationTotal();*/
                                    
                                /*statistiques
                reclamationservice.statReclamationParType(EtatReclamation.En_Cours);*/
    }

}
