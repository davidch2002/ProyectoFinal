package com.example.proyectofinal;

import java.io.Serializable;

public class User implements Serializable {
    private String user, pwd, names;

    public User(String user, String pwd, String names) {
        this.user = user;
        this.pwd = pwd;
        this.names = names;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }
}