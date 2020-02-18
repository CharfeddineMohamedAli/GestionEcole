
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
    
    // les attributs 
 private static DataBase data;
    private Connection con;
    String url = "jdbc:mysql://localhost:3306/stage";
    String login = "root";
    String pwd = "";

        //  constructeur 
    private DataBase() {
        try {
            con = DriverManager.getConnection(url, login, pwd);
            System.out.println("connexion etablie");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
   

    public Connection getConnection() {
        return con;
    }

    public static DataBase getInstance() {
        if (data == null) {
            data = new DataBase();
        }
        return data;
    }

    

    
    
}
