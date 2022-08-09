package com.example.app;

public class User {
    private String User_name;
    private String Number_phone;
    private String Login;
    private String Password;

    public User(String user_name, String number_phone, String login, String password) {
        User_name = user_name;
        Number_phone = number_phone;
        Login = login;
        Password = password;
    }

    public User() {

    }

    public String getUser_name() {
        return User_name;
    }

    public void setUser_name(String user_name) {
        User_name = user_name;
    }

    public String getNumber_phone() {
        return Number_phone;
    }

    public void setNumber_phone(String number_phone) {
        Number_phone = number_phone;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
