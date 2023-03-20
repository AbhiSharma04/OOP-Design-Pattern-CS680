package edu.umb.cs680.hw05.ModelABC;

import edu.umb.cs680.hw05.*;

public class PrintJobExecutor extends edu.umb.cs680.hw05.PrintingFramework.PrintJobExecutor {
    private boolean isActive = false;

    @Override
    protected void doAuthentication(EncryptedString password, SecurityContext context) throws RuntimeException {
        context.login(password);
        if(context.getState() instanceof  LoggedIn)
            isActive = true;
        else {
            throw new RuntimeException("Authentication: Login Failed");
        }
    }



    @Override
    protected void doAccessControl()  {

    }

    @Override
    public void doPrint() {
        if(isActive)
            System.out.println("Print Job from ABC");

    }

    @Override
    protected void doErrorHandling() {

    }

    public static void main(String[] args) throws Throwable {




    }
}
