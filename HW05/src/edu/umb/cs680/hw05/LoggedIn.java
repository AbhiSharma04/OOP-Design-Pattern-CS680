package edu.umb.cs680.hw05;

public class LoggedIn implements State {
    public static LoggedIn logInInstance = null;
    public SecurityContext securityContext = null;

    public LoggedIn(SecurityContext securityContext){
        this.securityContext = securityContext;
    }

    public static LoggedIn getInstance(SecurityContext securityContext){
        if(logInInstance == null){
            logInInstance = new LoggedIn(securityContext);
        }
        return logInInstance;
    }

    public State login(EncryptedString password) {
        if(!securityContext.isActive()){
            securityContext.changeState(LoggedOut.getInstance(securityContext));
            securityContext.login(password);
            securityContext.isActive = true;
        }
        return logInInstance;
    }



    public State logout() {
        securityContext.changeState(LoggedOut.getInstance(securityContext));
        securityContext.isActive = false;
        return logInInstance;
    }
}

