package edu.umb.cs680.hw05;

public class SecurityContext {
    public boolean isActive;
    public State state;


    public SecurityContext(User user){
        isActive = false;
        state = LoggedOut.getInstance(this);

    }

    public void changeState(State newState){
        state = newState;
    }

    public void login(EncryptedString password){
        state.login(password);
        isActive = true;
    }



    public void logout(){
        state.logout();
        isActive = false;
    }


    public boolean isActive(){
        return isActive;
    }

    public State getState(){
        return state;
    }

}
