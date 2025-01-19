package org.example;

public class User {
    public String password;
    public String login;
    public Role role;

    public User( String login, String password, Role role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }
}
