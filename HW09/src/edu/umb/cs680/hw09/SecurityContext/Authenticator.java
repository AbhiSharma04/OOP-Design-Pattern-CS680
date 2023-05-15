package edu.umb.cs680.hw09.SecurityContext;

public class Authenticator {
    public static boolean authenticate(SecurityContext contxt , EncryptedString pass)
    {
            if ( contxt.getpassword ().equals (pass.pwd) ) {
                return true;
            }
            else {
                return false;
        }
    }
}
