package edu.umb.cs680.hw09.PrintingFramework;

import edu.umb.cs680.hw09.SecurityContext.EncryptedString;
import edu.umb.cs680.hw09.SecurityContext.SecurityContext;

public class PrintJobExecutor {
    public void execute(Command job, EncryptedString password, SecurityContext context) throws Exception {
        if(job!=null) {
            try {
                doAuthentication (password, context);
                doAccessControl ();
                doPrint (job);
            } catch (RuntimeException exception) {
                doErrorHandling ();
                throw new RuntimeException ("The authentication failed");
            }
        }
        else throw new RuntimeException ("Printjob object is null");

    }




    protected void doAuthentication(EncryptedString password, SecurityContext context) throws RuntimeException{ }

    protected void doAccessControl()  { }

    protected void doPrint(Command job) throws RuntimeException{ }

    protected void doErrorHandling() throws Exception{ }
}
