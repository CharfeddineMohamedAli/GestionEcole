package Test;

import Entite.Note;

import Service.Note_Service;
import Entite.Type;
import static Entite.Type.cc;
import static Entite.Type.ds;



import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dell is hell
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
       // Note note=new Note(16,5,6,7,ds);
        Note_Service noteService= new Note_Service();
        noteService.getmatiérebyid();
   }
    
}
