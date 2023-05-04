package edu.umb.cs680.hw09.PrintingFramework;

import edu.umb.cs680.hw09.Command;
import edu.umb.cs680.hw09.SecurityContext.EncryptedString;
import edu.umb.cs680.hw09.SecurityContext.SecurityContext;

public class PrintJobExecutor {
    public void execute(Command job, EncryptedString password, SecurityContext context) throws Throwable{
        try{
            doAuthentication(password, context);
            doAccessControl();
            doPrint();
        }
        catch(RuntimeException exception){
            doErrorHandling();
            throw exception;
        }

    }




    protected void doAuthentication(EncryptedString password, SecurityContext context) throws RuntimeException{ }

    protected void doAccessControl()  { }

    protected void doPrint() throws RuntimeException{ }

    protected void doErrorHandling() { }
}
