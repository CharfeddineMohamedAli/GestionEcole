/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tache_pi;

import Entities.Administrateur;
import Entities.Classe;
import Entities.Enseignant;
import Entities.Etudiant;
import Entities.User;
import Services.AdminService;
import Services.ClasseService;
import Services.UserService;
import java.sql.SQLException;

/**
 *ww
 * @author admin
 */
public class Tache_PI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        
        User user4=new User("Saief","Khalfallah","hrijokl","hyfeujdikol");
        user4.setEnabled(Boolean.TRUE);
      
        Administrateur admin5 = new Administrateur(6,"Admin6","Admin66") ;      
        Classe classe4 = new Classe(2,9,2,40);
        
        Administrateur a = new Administrateur();
        
        AdminService adminService = new AdminService();
        
        
        Etudiant e = new Etudiant();
        
        UserService userService=new UserService();
        
        ClasseService classeService= new ClasseService();
        //userService.ajouterUser(user4);
       
        
        adminService.ajouterAdmin(admin5);
        //adminService.modifierAdmin(admin5);
        //adminService.supprimerAdmin(admin5);
        //adminService.FindNomUserByIdAdmin(4);
        //adminService.readAll();
        //adminService.TrierParDateCreation();
        
        
        //userService.FindNomUserByIdUser(2);
        //userService.ajouterUser(user4);
        //userService.ajouterEtudiant(etudiant3);
        //userService.readAll();
        //userService.TrierParDateCreation();
        
     
        //classeService.ajouterClasse(classe4);
        //classeService.FindNumClasseByIdClasse(2);
        //classeService.readAll();
        //System.out.println(classeService.FindClasseByIdUser(3));
       
        
    }
    
}
