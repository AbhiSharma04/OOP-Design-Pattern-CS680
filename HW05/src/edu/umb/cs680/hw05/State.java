package edu.umb.cs680.hw05;

public interface State{
    public State login(EncryptedString password);
    public State logout();

}

