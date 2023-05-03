package edu.umb.cs680.hw09.ModelABC;

import edu.umb.cs680.hw09.PrintJob;
import edu.umb.cs680.hw09.SecurityContext.EncryptedString;
import edu.umb.cs680.hw09.SecurityContext.LoggedIn;
import edu.umb.cs680.hw09.SecurityContext.SecurityContext;

public class PrintJobExecutor extends edu.umb.cs680.hw09.PrintingFramework.PrintJobExecutor {
    boolean isActive = false;

    @Override
    protected void doAuthentication(EncryptedString encryptedString, SecurityContext context) throws RuntimeException {
        context.login(encryptedString);
        if(context.getState() instanceof LoggedIn) isActive = true;
        else {
            throw new RuntimeException("Auth Fail, Cannot print");
        }
    }

    @Override
    protected void doAccessControl()  { }

    PrintJob pj = new PrintJob();
    @Override
    public void doPrint() {
        if(isActive == true){
            pj.execute();
            System.out.println("The print job executed from printer: ABC");
        }
        else {
            System.out.println("Password wrong");}
        }

    @Override
    protected void doErrorHandling() {
        System.out.println("error handling");
    }

    public static void main(String[] args) {

    }
}
