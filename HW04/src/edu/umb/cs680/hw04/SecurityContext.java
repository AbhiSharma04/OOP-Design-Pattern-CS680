package edu.umb.cs680.hw04;

public class SecurityContext {

    private State state;
    private boolean isActive= false;
    private User user;

    public SecurityContext(User user){
        this.user=user;
        this.state=new LoggedOut(this);
    }

    public void login(EncryptedString pass){
        this.state.login(pass);
    }
    public void logout(){
        this.state.logout();
    }
    public void changeState(State state){
        this.state=state;
    }
    protected boolean isActive(){
        if(!this.isActive){
            this.isActive=true;
            return false;
        }
        return isActive;
    }
    public State getState(){
        return this.state;
    }

  public static void main(String[] args) {
       System.out.println("Message from security Context");
    }
}
