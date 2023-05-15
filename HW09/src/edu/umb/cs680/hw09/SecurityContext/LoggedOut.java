package edu.umb.cs680.hw09.SecurityContext;

public class LoggedOut implements State {
    private static LoggedOut instance = null;

    public SecurityContext contxt = null;
    private LoggedOut(SecurityContext contxt){
        this.contxt=contxt;
    }


    public static  LoggedOut getInstance(SecurityContext contxt) {
        if(instance == null ) {
            instance = new LoggedOut(contxt);
        }
        return instance;
    }
    public void login(EncryptedString pass) throws RuntimeException{
        if(Authenticator.authenticate(contxt, pass)){
            this.contxt.changeState(LoggedIn.getInstance(this.contxt));
        }

        else{
            throw new RuntimeException ("Failed login");
        }
    }

    public void logout(){
        contxt.isActive=false;
    }
}
