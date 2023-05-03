package edu.umb.cs680.hw09.PrintingFramework;

import edu.umb.cs680.hw09.Command;
import edu.umb.cs680.hw09.SecurityContext.EncryptedString;
import edu.umb.cs680.hw09.SecurityContext.SecurityContext;

public class PrintJobExecutor {
    public void execute(Command job, EncryptedString password, SecurityContext context) throws Throwable{
        try{
            doAuthentication(password, context);
        }
        catch (RuntimeException exception){
            doErrorHandling();
            throw exception;
        }

        doAccessControl();
        doPrint();
    }




    protected void doAuthentication(EncryptedString password, SecurityContext context) throws RuntimeException{ }

    protected void doAccessControl()  { }

    protected void doPrint() { }

    protected void doErrorHandling() { }
}
