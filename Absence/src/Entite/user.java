
package Entite;

/**
 *
 * @author HPAY104-I5-1TR
 */
public class user { 
    private int Id_user;
    private String first_Name;
    private String last_Name;
    private String user_Name;
    private String pasword;
    private String email;
    private int phone_nomber;
    private String gender;
    private int CIN;
    private String account_Date;
    private String Image_user;
    private int age;

    public user() {
    }

    public user(int Id_user, String first_Name, String last_Name, String user_Name, String pasword, String email, int phone_nomber, String gender, int CIN, String account_Date, String Image_user, int age) {
        this.Id_user = Id_user;
        this.first_Name = first_Name;
        this.last_Name = last_Name;
        this.user_Name = user_Name;
        this.pasword = pasword;
        this.email = email;
        this.phone_nomber = phone_nomber;
        this.gender = gender;
        this.CIN = CIN;
        this.account_Date = account_Date;
        this.Image_user = Image_user;
        this.age = age;
    }

    public int getIduser() {
        return Id_user;
    }

    public String getFirst_Name() {
        return first_Name;
    }

    public String getLast_Name() {
        return last_Name;
    }

    public String getUser_Name() {
        return user_Name;
    }

    public String getPasword() {
        return pasword;
    }

    public String getEmail() {
        return email;
    }

    public int getPhone_nomber() {
        return phone_nomber;
    }

    public String getGender() {
        return gender;
    }

    public int getCIN() {
        return CIN;
    }

    public String getAccount_Date() {
        return account_Date;
    }

    public String getImage_user() {
        return Image_user;
    }

    public int getAge() {
        return age;
    }

    public void setIduser(int iduser) {
        this.Id_user = iduser;
    }

    public void setFirst_Name(String first_Name) {
        this.first_Name = first_Name;
    }

    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
    }

    public void setUser_Name(String user_Name) {
        this.user_Name = user_Name;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone_nomber(int phone_nomber) {
        this.phone_nomber = phone_nomber;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setCIN(int CIN) {
        this.CIN = CIN;
    }

    public void setAccount_Date(String account_Date) {
        this.account_Date = account_Date;
    }

    public void setImage_user(String Image_user) {
        this.Image_user = Image_user;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "user{" + "Id_user=" + Id_user + ", first_Name=" + first_Name + ", last_Name=" + last_Name + ", user_Name=" + user_Name + ", pasword=" + pasword + ", email=" + email + ", phone_nomber=" + phone_nomber + ", gender=" + gender + ", CIN=" + CIN + ", account_Date=" + account_Date + ", Image_user=" + Image_user + ", age=" + age + '}';
    }
    
    
    
}
