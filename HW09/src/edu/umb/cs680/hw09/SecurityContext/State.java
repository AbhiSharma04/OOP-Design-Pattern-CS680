package edu.umb.cs680.hw09.SecurityContext;

public interface State {
    public State login(EncryptedString pass);
    public State logout();

}
