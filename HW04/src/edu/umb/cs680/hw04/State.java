package edu.umb.cs680.hw04;

public interface State {
    public State login(EncryptedString pass);
    public State logout();

}
