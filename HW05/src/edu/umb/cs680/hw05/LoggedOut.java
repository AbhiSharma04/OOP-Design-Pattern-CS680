package edu.umb.cs680.hw05;

public class LoggedOut implements State {
    public static LoggedOut logOutInstance = null;
    public SecurityContext securityContext = null;

    public LoggedOut(SecurityContext securityContext){
        this.securityContext = securityContext;
    }

    public static LoggedOut getInstance(SecurityContext securityContext){
        if(logOutInstance == null){
            logOutInstance = new LoggedOut(securityContext);
        }
        return logOutInstance;
    }

    public State login(EncryptedString password) {
        if (Authenticator.authenticate(securityContext, new EncryptedString()) ){
            securityContext.changeState(LoggedIn.getInstance(securityContext));
        }
        else{
            System.out.println("Error Logging In");
        }
        return logOutInstance;
    }

    public State logout() {
        securityContext.isActive = false;
        return logOutInstance;
    }
}
