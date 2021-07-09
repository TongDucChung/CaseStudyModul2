package com.company;

public class Account {
    private String acc;
    private String pass;



    public Account(String acc, String pass) {
        this.acc = acc;
        this.pass = pass;


    }

    @Override
    public String toString () {
        return "Account{" +
                "acc='" + acc + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }

    public String ghi1(){
        return acc + "," +pass;
    }
    public Account(){

    }

    public String getAcc () {
        return acc;
    }

    public void setAcc (String acc) {
        this.acc = acc;
    }

    public String getPass () {
        return pass;
    }

    public void setPass (String pass) {
        this.pass = pass;
    }
}
