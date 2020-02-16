package Entite;

/**
 *
 * @author Hudson
 */
public class User {

    private int Id_User;
    private String Login;
    private String Mdp;

    public User(int Id_User, String Login, String Mdp) {
        this.Id_User = Id_User;
        this.Login = Login;
        this.Mdp = Mdp;
    }

    public int getId_User() {
        return Id_User;
    }

    public String getLogin() {
        return Login;
    }

    public String getMdp() {
        return Mdp;
    }

    @Override
    public String toString() {
        return "User{" + "Id_User=" + Id_User + ", Login=" + Login + ", Mdp=" + Mdp;
    }

}
