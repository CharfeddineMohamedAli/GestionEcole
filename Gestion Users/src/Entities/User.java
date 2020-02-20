/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;

/**
 *
 * @author admin
 */
public class User {

    private int id_user;
    private String first_Name;
    private String last_Name;
    private String user_Name;
    private String password;
    private String email;
    private int phone_number;
    private String gender;
    private int CIN;
    private String account_Date;
    private String Image_user;
    private int age;
    private  String classe;
    private Level level;
    private String usernameCanonical;
    private String emailCanonical;
    private Boolean enabled;
    private String salt;
    private String plainPassword;
    private Date lastLogin;
    private String role;
    

    public User() {
    }

    public User(int id_user, String first_Name, String last_Name, String user_Name, String password, String email, int phone_number, String gender, int CIN, String account_Date, String Image_user, int age, String classe, String usernameCanonical, String emailCanonical, Boolean enabled, String salt, String plainPassword, Date lastLogin, String role) {
        this.id_user = id_user;
        this.first_Name = first_Name;
        this.last_Name = last_Name;
        this.user_Name = user_Name;
        this.password = password;
        this.email = email;
        this.phone_number = phone_number;
        this.gender = gender;
        this.CIN = CIN;
        this.account_Date = account_Date;
        this.Image_user = Image_user;
        this.age = age;
        this.classe = classe;
        this.usernameCanonical = usernameCanonical;
        this.emailCanonical = emailCanonical;
        this.enabled = enabled;
        this.salt = salt;
        this.plainPassword = plainPassword;
        this.lastLogin = lastLogin;
        this.role = role;
    }

    public User(int id_user, String first_Name, String last_Name, String user_Name, String password, String email, int phone_number, String gender, int CIN, String account_Date, String Image_user, int age, String classe) {
        this.id_user = id_user;
        this.first_Name = first_Name;
        this.last_Name = last_Name;
        this.user_Name = user_Name;
        this.password = password;
        this.email = email;
        this.phone_number = phone_number;
        this.gender = gender;
        this.CIN = CIN;
        this.account_Date = account_Date;
        this.Image_user = Image_user;
        this.age = age;
        this.classe = classe;
    }

    public User(String first_Name, String last_Name, String user_Name, String password) {
        this.first_Name = first_Name;
        this.last_Name = last_Name;
        this.user_Name = user_Name;
        this.password = password;
    }

    public int getId_user() {
        return id_user;
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

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public int getPhone_number() {
        return phone_number;
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

    public String getClasse() {
        return classe;
    }

    public String getUsernameCanonical() {
        return usernameCanonical;
    }

    public String getEmailCanonical() {
        return emailCanonical;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public String getSalt() {
        return salt;
    }

    public String getPlainPassword() {
        return plainPassword;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public String getRole() {
        return role;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
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

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public void setUsernameCanonical(String usernameCanonical) {
        this.usernameCanonical = usernameCanonical;
    }

    public void setEmailCanonical(String emailCanonical) {
        this.emailCanonical = emailCanonical;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public void setPlainPassword(String plainPassword) {
        this.plainPassword = plainPassword;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "User{" + "id_user=" + id_user + ", first_Name=" + first_Name + ", last_Name=" + last_Name + ", user_Name=" + user_Name + ", password=" + password + ", email=" + email + ", phone_number=" + phone_number + ", gender=" + gender + ", CIN=" + CIN + ", account_Date=" + account_Date + ", Image_user=" + Image_user + ", age=" + age + ", classe=" + classe + ", usernameCanonical=" + usernameCanonical + ", emailCanonical=" + emailCanonical + ", enabled=" + enabled + ", salt=" + salt + ", plainPassword=" + plainPassword + ", lastLogin=" + lastLogin + ", role=" + role + '}';
    }

}
