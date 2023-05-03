package edu.umb.cs680.hw09.SecurityContext;

public class LoggedOut implements State {
    public static LoggedOut instance = null;

    public SecurityContext contxt = null;
    public LoggedOut(SecurityContext contxt){
        this.contxt=contxt;
    }


    public static  LoggedOut getInstance(SecurityContext contxt) {
        if(instance == null ) {
            instance = new LoggedOut(contxt);
        }
        return instance;
    }
    public State login(EncryptedString pass){
        if(Authenticator.authenticate(contxt, pass)){
            this.contxt.changeState(LoggedIn.getInstance(this.contxt));
        }

        else{
            System.out.println("error login");
        }
        return instance;
    }

    public State logout(){
        contxt.isActive=false;

        return instance;
    }
}
