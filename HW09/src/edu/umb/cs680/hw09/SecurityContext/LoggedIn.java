package edu.umb.cs680.hw09.SecurityContext;

public class LoggedIn implements State {
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
    public void login(EncryptedString pass) {
        if (!contxt.isActive()) {
            contxt.changeState(LoggedOut.getInstance(contxt));
            contxt.login(pass);
            contxt.isActive=true;
        }
    }
    public void logout() {
        contxt.changeState(LoggedOut.getInstance(contxt));
        contxt.isActive = false;
        }



}
