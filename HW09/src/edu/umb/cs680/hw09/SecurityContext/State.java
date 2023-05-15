package edu.umb.cs680.hw09.SecurityContext;

public interface State {
    public void login(EncryptedString pass);
    public void logout();

}
