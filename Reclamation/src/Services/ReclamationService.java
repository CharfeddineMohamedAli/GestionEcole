/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Matiere;
import Entities.Note;
import Utils.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import Entities.Reclamation;
import Entities.ReclamationNote;
import Entities.ReclamationProf;
import Entities.Type_note_matiere;
import Entities.User;
import Utils.EtatReclamation;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.Vector;

/**
 *
 * @author KattaX
 */
public class ReclamationService {

    private Connection con = DataSource.getInstance().getConnection();
    private Statement ste;

    public ReclamationService() {
        try {
            ste = con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public Reclamation rechercherReclamationParID(int id) throws SQLException {
        String req1 = "SELECT * FROM Reclamation WHERE id=?";
        PreparedStatement steprep = con.prepareStatement(req1);
        steprep.setInt(1, id);

        Reclamation r = null;
        ResultSet result = steprep.executeQuery();
        if (result.first()) {
            User user = new User();
            user.setId_user(result.getInt("id_user"));
            r = new Reclamation(id, result.getString(2), user);
            r.setEtat(EtatReclamation.values()[result.getInt(4)]);
        }
        System.out.println(r);
        return r;
    }

    public boolean existReclamation(int id) throws SQLException {
        return rechercherReclamationParID(id) != null;
    }
                /*  ajout RecAutre */
    public void ajouterReclamation(Reclamation reclamation) throws SQLException {
        String req1 = "INSERT INTO `Reclamation` (`desc`,`id_user`) "
                + "VALUES ('" + reclamation.getDesc() + "', '" + reclamation.getUser().getId_user() + "');";
        ste.executeUpdate(req1);
        System.out.println("Reclamation ajouté");
    }   
                 /*  ajout RecNote */
    public void ajouterReclamationNote(ReclamationNote reclamation) throws SQLException {
        String req1 = "INSERT INTO `ReclamationNote` (`desc`,`id_user`,`id_note`) "
                + "VALUES ('" + reclamation.getDesc() + "', '" + reclamation.getUser().getId_user() + "', '" + reclamation.getNote().getId_note() + "');";
        ste.executeUpdate(req1);
        System.out.println("Reclamation Note ajouté");
    }
                /*  ajout RecProf */
    public void ajouterReclamationProf (ReclamationProf reclamation) throws SQLException {
        String req1 = "INSERT INTO `ReclamationProf` (`desc`,`id_user`,`id_enseignant`) "
                + "VALUES ('" + reclamation.getDesc() + "', '" + reclamation.getUser().getId_user() + "', '" + reclamation.getProf().getId_user() + "');";
        ste.executeUpdate(req1);
        System.out.println("Reclamation Prof ajouté");    
        
    }
                /*  Modif RecAutre */
    public void modifierReclamation(Reclamation reclamation) throws SQLException {
        String req1 = "UPDATE `Reclamation` "
                + "SET `desc`=?, etat=? where id=?";
        PreparedStatement preparedStatement = con.prepareStatement(req1);
        preparedStatement.setString(1, reclamation.getDesc());
        preparedStatement.setInt(2, reclamation.getEtat().ordinal());//ordinal=id
        preparedStatement.setInt(3, reclamation.getId());

        if (preparedStatement.executeUpdate() > 0) {
            System.out.println("Reclamation modifier");
        } else {
            System.out.println("Reclamation non modifier");
        }
    }
                /*  Modif RecNote */
      public void modifierReclamationNote(ReclamationNote reclamation) throws SQLException {
        String req1 = "UPDATE `ReclamationNote` "
                + "SET `desc`=?, id_note=? , etat=? where id=?";
        PreparedStatement preparedStatement = con.prepareStatement(req1);
        preparedStatement.setString(1, reclamation.getDesc());
        preparedStatement.setInt(2,reclamation.getNote().getId_note());
        preparedStatement.setInt(3,reclamation.getEtat().ordinal());//ordinal=id
        preparedStatement.setInt(4,reclamation.getId_RecNote());

        if (preparedStatement.executeUpdate() > 0) {
            System.out.println("Reclamation Note modifier");
        } else {
            System.out.println("Reclamation note non modifier");
        }
    }
      
                /*  Modif RecProf */
      public void modifierReclamationProf(ReclamationProf reclamation) throws SQLException {
        String req1 = "UPDATE `ReclamationProf` "
                + "SET `desc`=?, id_enseignant=? , etat=? where id=?";
        PreparedStatement preparedStatement = con.prepareStatement(req1);
        preparedStatement.setString(1, reclamation.getDesc());
        preparedStatement.setInt(2,reclamation.getProf().getId_user());
        preparedStatement.setInt(3,reclamation.getEtat().ordinal());//ordinal=id
        preparedStatement.setInt(4,reclamation.getId_RecProf());

        if (preparedStatement.executeUpdate() > 0) {
            System.out.println("Reclamation Prof modifier");
        } else {
            System.out.println("Reclamation Prof non modifier");
        }
    }
    
    public void suprimerReclamation(Reclamation reclamation) throws SQLException {
        String req1 = "DELETE FROM `Reclamation` where id=?";
        PreparedStatement preparedStatement = con.prepareStatement(req1);
        preparedStatement.setInt(1, reclamation.getId());

        if (preparedStatement.executeUpdate() > 0) {
            System.out.println("Reclamation supprimer");
        } else {
            System.out.println("Reclamation non supprimer");
        }
    }
    public void suprimerReclamationNote(ReclamationNote reclamation) throws SQLException {
        String req1 = "DELETE FROM `ReclamationNote` where id=?";
        PreparedStatement preparedStatement = con.prepareStatement(req1);
        preparedStatement.setInt(1, reclamation.getId_RecNote());

        if (preparedStatement.executeUpdate() > 0) {
            System.out.println("Reclamation Note supprimer");
        } else {
            System.out.println("Reclamation Note non supprimer");
        }
    }
        public void suprimerReclamationProf(ReclamationProf reclamation) throws SQLException {
        String req1 = "DELETE FROM `ReclamationProf` where id=?";
        PreparedStatement preparedStatement = con.prepareStatement(req1);
        preparedStatement.setInt(1, reclamation.getId_RecProf());

        if (preparedStatement.executeUpdate() > 0) {
            System.out.println("Reclamation Prof supprimer");
        } else {
            System.out.println("Reclamation Prof non supprimer");
        }
    }

    public int nbReclamationParType(EtatReclamation etatReclamation) throws SQLException {
        int nb = 0;

        String req1 = "SELECT count(*) FROM `Reclamation` where etat=?";
        PreparedStatement preparedStatement = con.prepareStatement(req1);
        preparedStatement.setInt(1, etatReclamation.ordinal());

        ResultSet result = preparedStatement.executeQuery();
        if (result.first()) {
            nb = result.getInt(1);
        }

        return nb;
    }

    public int nbReclamationTotal() throws SQLException {
        int nb = 0;

        String req1 = "SELECT count(*) FROM `Reclamation`";
        ResultSet result = ste.executeQuery(req1);
        if (result.first()) {
            nb = result.getInt(1);
        }
        
        System.out.println(nb);
        return nb;
        
    }

    public double statReclamationParType(EtatReclamation etatReclamation) throws SQLException {
        float res = ((float) nbReclamationParType(etatReclamation) / nbReclamationTotal());
        System.out.println(Double.valueOf(new DecimalFormat("##.##").format(res * 100))+"%");
        return Double.valueOf(new DecimalFormat("##.##").format(res * 100));
    }

    public Vector<Reclamation> getAll() throws SQLException {

        Vector<Reclamation> reclamations = new Vector<Reclamation>();

        String req1 = "SELECT * FROM `Reclamation`";
        ResultSet result = ste.executeQuery(req1);
        while (result.next()) {
            User user = new User();
            user.setId_user(result.getInt("id_user"));
            Reclamation r = new Reclamation(result.getInt(1), result.getString(2), user);
            r.setEtat(EtatReclamation.values()[result.getInt(4)]);

            reclamations.add(r);
        }
        System.out.println(reclamations);
        return reclamations;
    }
    //get all reclamations by userID

    public Vector<Reclamation> getAllParUserID(int id_user) throws SQLException {

        Vector<Reclamation> reclamations = new Vector<Reclamation>();

        String req1 = "SELECT * FROM `Reclamation` where id_user=?";
        PreparedStatement preparedStatement = con.prepareStatement(req1);
        preparedStatement.setInt(1, id_user);

        ResultSet result = preparedStatement.executeQuery();
        while (result.next()) {
            User user = new User("", "", "");
            user.setId_user(result.getInt("id_user"));
            Reclamation r = new Reclamation(result.getInt(1), result.getString(2), user);
            r.setEtat(EtatReclamation.values()[result.getInt(4)]);

            reclamations.add(r);

        }
        System.out.println(reclamations);
        return reclamations;
    }
    //get all notes by userID

    public Vector<Note> getNoteParUserID(int id_user, String matiere) throws SQLException {

        Vector<Note> notes = new Vector<Note>();

        String req1 = "SELECT * FROM `note` where id_user=? AND matiere=?";
     //   String req1 = "SELECT notes,matiere,type,nom_mat FROM `note` join `matiere` on note.id_mat = matiere.id_mat where id_user=? AND id_mat=?";
        
        
        PreparedStatement preparedStatement = con.prepareStatement(req1);
        preparedStatement.setInt(1, id_user);
        preparedStatement.setString(2, matiere);

        ResultSet result = preparedStatement.executeQuery();
        while (result.next()) {
            User user = new User();
            user.setId_user(result.getInt("id_user"));
            Note n = new Note(result.getInt(1), result.getInt(3));
            n.setMatiere(Matiere.valueOf(result.getString(4)));
            n.setType(Type_note_matiere.valueOf(result.getString(7)));

            notes.add(n);

        }
        System.out.println(notes);
        return notes;
    }

    public User findUSerById_user(int id_user) throws SQLException {

        Vector<User> enseignants = new Vector<User>();
        User user1 = new User();
        String req1 = "SELECT * FROM `user` where id_user=?";
        PreparedStatement preparedStatement = con.prepareStatement(req1);
        preparedStatement.setInt(1, id_user);

        ResultSet result = preparedStatement.executeQuery();
        while (result.next()) {
            User user = new User();
            user.setId_user(result.getInt("id_user"));
            user.setFirst_Name(result.getString(2));
            enseignants.add(user);

        }

        for (User u : enseignants) {
            user1 = u;
        }
        return user1;
    }
    //get all prof by userID

    public Vector<User> getListEnseignantsClasse(int id_classe) throws SQLException {

        Vector<User> enseignants = new Vector<User>();

        String req1 = "SELECT * FROM `classeenseignant` where id_classe=?";
        PreparedStatement preparedStatement = con.prepareStatement(req1);
        preparedStatement.setInt(1, id_classe);

        ResultSet result = preparedStatement.executeQuery();
        while (result.next()) {
            User user = findUSerById_user(result.getInt("id_enseignant"));
            enseignants.add(user);

        }

        return enseignants;
    }

}
