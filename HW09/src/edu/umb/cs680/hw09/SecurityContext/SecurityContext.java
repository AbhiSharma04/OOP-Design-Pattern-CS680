package edu.umb.cs680.hw09.SecurityContext;

public class SecurityContext {

    public State state;
    public boolean isActive;
    public User user;

    public SecurityContext(User user){
        isActive=false;
        this.user=user;
        this.state=new LoggedOut(this);
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
}
