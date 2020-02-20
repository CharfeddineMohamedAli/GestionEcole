/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Enseignant;
import Entities.Etudiant;
import Entities.Parent;
import Entities.User;
import Utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserService {

    private Connection con = DataSource.getInstance().getConnection();
    private Statement ste;
    Etudiant e = new Etudiant();

    public UserService() {
        try {
            ste = con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void ajouterUser(User user) throws SQLException {
        Date date1 = new Date();
        String account_Date = new SimpleDateFormat("yyyy-MM-dd").format(date1);
        user.setAccount_Date(account_Date);
        
        String req1 = "INSERT INTO `user` (`first_Name`,`last_Name`,`user_Name`,`password`, `email` , `phone_number`, `gender`, `CIN`, `account_Date`, `Image_user`, `age`, `classe`,`level` , `usernameCanonical`,`emailCanonical`,`enabled`,`salt`,`plainPassword`,`lastLogin`,`role` ) "
                + "VALUES ('" + user.getFirst_Name() + "', '" + user.getLast_Name()
                + "', '" + user.getUser_Name() + "', '" + user.getPassword() + "', '" + user.getEmail() + "', '"
                + user.getPhone_number() + "', '" + user.getGender() + "', '" + user.getCIN() + "', '" + user.getAccount_Date() + "', '" + user.getImage_user() + "', '" + user.getAge() + "', '" + user.getClasse() + "', '" +  user.getLevel() + "', '" + user.getUsernameCanonical() + "' , '" + user.getEmailCanonical() + "' , '" + user.getEnabled() + "' , '" + user.getSalt() + "' , '" + user.getPlainPassword() + "' , '" + user.getLastLogin() + "' , '" + user.getRole() + "');";
        ste.executeUpdate(req1);
        System.out.println("Utilisateur ajouté");

    }

    public void modifierUser(User u) throws SQLException {
        String sql = "UPDATE user SET `first_Name`=?,`last_Name`=?,`user_Name`=?,`password`=?, `email`=?, "
                + "`phone_number`=?, `gender`=?, `CIN`=?, `account_Date`=?, `Image_user`=?, `age`=?, `classe`=? , `level`=? , `usernameCanonical`=? , `emailCanonical`=?  , `plainPassword`=? , `role`=? WHERE id_user=" + u.getId_user();
        PreparedStatement ste;
        try {
            ste = con.prepareStatement(sql);

            ste.setString(1, u.getFirst_Name());

            ste.setString(2, u.getLast_Name());
            ste.setString(3, u.getUser_Name());
            ste.setString(4, u.getPassword());
            ste.setString(5, u.getEmail());
            ste.setInt(6, u.getPhone_number());
            ste.setString(7, u.getGender());
            ste.setInt(8, u.getCIN());
            ste.setString(9, u.getAccount_Date());
            ste.setString(10, u.getImage_user());
            ste.setInt(11, u.getAge());

            ste.setString(12, u.getClasse());
            ste.setString(13,u.getLevel().toString());
            ste.setString(14, u.getUsernameCanonical());
            ste.setString(15, u.getEmailCanonical());
           
           
            ste.setString(16, u.getPlainPassword());
          
            ste.setString(17, u.getRole());

            ste.executeUpdate();
            int rowsUpdated = ste.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("La modification de l'utilisateur : " + u.getUser_Name() + " a été éffectuée avec succès ");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void supprimerUser(User u) {

        try {
            String req = "DELETE FROM `user` WHERE `user`.`id_user` = ?";
            PreparedStatement ste = con.prepareStatement(req);
            ste.setInt(1, u.getId_user());
            ste.executeUpdate();
            System.out.println("Utilisateur supprimé");

        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<User> readAll() throws SQLException {
        List<User> list = new ArrayList<>();
        ResultSet res = ste.executeQuery("select * from user ");
        User u = null;
        while (res.next()) {
            u = new User(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getInt(7), res.getString(8), res.getInt(9), res.getString(10), res.getString(11), res.getInt(12), res.getString(13));
            u.setLevel(Entities.Level.valueOf(res.getString(14)));
            u.setRole(res.getString(21));
            list.add(u);
            System.out.println("all" + list);
        }
        return list;
    }

    public String FindNomUserByIdUser(int id_user) throws SQLException {
        String req = "SELECT * from user where Id_User='" + id_user + "'";
        ResultSet res = ste.executeQuery(req);

        String nom = null;
        while (res.next()) {

            nom = res.getString(2);
            System.out.println(nom);
        }
        return nom;
    }

    public List<User> TrierParDateCreation() throws SQLException {
        List<User> list = new ArrayList<>();
        ResultSet res = ste.executeQuery("select * from user ORDER BY account_Date ASC");
        User com = null;
        while (res.next()) {
            com = new User(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getInt(7), res.getString(8), res.getInt(9), res.getString(10), res.getString(11), res.getInt(12), res.getString(13));
            list.add(com);
        }
        System.out.println(list);
        return list;
    }

    public String getUserRole(int id_user) throws SQLException {
        String req = "SELECT role from user where id_user='" + id_user + "'";
        ResultSet res = ste.executeQuery(req);
        String role = null;

        while (res.next()) {
            role = res.getString("role");

        }

        return role;
    }

    public User getUserById(int id_user) throws SQLException {
        User user = new User();
        Etudiant etudiant = new Etudiant();
        Enseignant enseignant = new Enseignant();
        Parent parent = new Parent();
        if (getUserRole(id_user) == "etudiant") {
            String req = "SELECT * from user where id_user='" + id_user + "'";
            ResultSet res = ste.executeQuery(req);
            while (res.next()) {
                etudiant.setId_user(res.getInt("id_user"));
                etudiant.setFirst_Name(res.getString("first_Name"));
                etudiant.setLast_Name(res.getString("last_Name"));
                etudiant.setUser_Name(res.getString("user_Name"));
                etudiant.setPassword(res.getString("password"));
                etudiant.setEmail(res.getString("email"));
                etudiant.setPhone_number(res.getInt("phone_number"));
                etudiant.setGender(res.getString("gender"));
                etudiant.setCIN(res.getInt("CIN"));
                etudiant.setAccount_Date(res.getString("account_Date"));
                etudiant.setImage_user(res.getString("Image_user"));
                etudiant.setAge(res.getInt("age"));
                etudiant.setClasse(res.getString("classe"));
                etudiant.setRole(res.getString("role"));
            }
            user = etudiant;
        }
        if (getUserRole(id_user) == "enseignant") {
            String req = "SELECT * from user where id_user='" + id_user + "'";
            ResultSet res = ste.executeQuery(req);
            while (res.next()) {
                enseignant.setId_user(res.getInt("id_user"));
                enseignant.setFirst_Name(res.getString("first_Name"));
                enseignant.setLast_Name(res.getString("last_Name"));
                enseignant.setUser_Name(res.getString("user_Name"));
                enseignant.setPassword(res.getString("password"));
                enseignant.setEmail(res.getString("email"));
                enseignant.setPhone_number(res.getInt("phone_number"));
                enseignant.setGender(res.getString("gender"));
                enseignant.setCIN(res.getInt("CIN"));
                enseignant.setAccount_Date(res.getString("account_Date"));
                enseignant.setImage_user(res.getString("Image_user"));
                enseignant.setAge(res.getInt("age"));
                enseignant.setClasse(res.getString("classe"));
                enseignant.setRole(res.getString("role"));
            }
            user = enseignant;
        }
        if (getUserRole(id_user) == "parent") {
            String req = "SELECT * from user where id_user='" + id_user + "'";
            ResultSet res = ste.executeQuery(req);
            while (res.next()) {
                parent.setId_user(res.getInt("id_user"));
                parent.setFirst_Name(res.getString("first_Name"));
                parent.setLast_Name(res.getString("last_Name"));
                parent.setUser_Name(res.getString("user_Name"));
                parent.setPassword(res.getString("password"));
                parent.setEmail(res.getString("email"));
                parent.setPhone_number(res.getInt("phone_number"));
                parent.setGender(res.getString("gender"));
                parent.setCIN(res.getInt("CIN"));
                parent.setAccount_Date(res.getString("account_Date"));
                parent.setImage_user(res.getString("Image_user"));
                parent.setAge(res.getInt("age"));
                parent.setRole(res.getString("Role"));
            }
            user = parent;
        }
        System.out.println(user);
        return user;
    }
}
