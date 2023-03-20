package edu.umb.cs680.hw04;

public class EncryptedString {
    private String password;
    public EncryptedString(){
        this.password="";

    }
    public EncryptedString(String password){
        this.password=password;
    }
    public String getPassword(){
        return this.password;
    }
}
