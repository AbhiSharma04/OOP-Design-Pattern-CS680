package edu.umb.cs680.hw09.SecurityContext;

public class SecurityContext {

    public State state;
    public static boolean isActive;
    public User user;
    private String password;

    public SecurityContext(User user,EncryptedString password){
        isActive=false;
        this.user=user;
        this.state=LoggedOut.getInstance (this);
        this.password=password.pwd;
    }

    public void login(EncryptedString pass){
        this.state.login(pass);
        isActive=true;
    }

    public void logout(){
        this.state.logout(); isActive = false;
    }
    public void changeState(State state){

        this.state=state;
    }
    public boolean isActive(){
       return isActive;
    }
    public State getState(){
        return this.state;
    }

    public String getpassword(){
        return password;
    }
}
