package edu.umb.cs680.hw04;

public class LoggedIn implements State{
    private static LoggedIn instance = null;
    private SecurityContext contxt = null;
    private LoggedIn (SecurityContext contxt) {
        this.contxt = contxt ;
    }

    public static LoggedIn getInstance(SecurityContext contxt) {
        if (instance == null) {
            instance = new LoggedIn(contxt);
        }
        return instance;
    }
    public State login(EncryptedString pass) {
        if (!contxt.isActive()) {
            contxt.changeState(LoggedOut.getInstance(contxt));
            contxt.login(pass);
        }

        return instance;
    }
    public State logout() {
        contxt.changeState(LoggedOut.getInstance(contxt));
        return instance; }



}
