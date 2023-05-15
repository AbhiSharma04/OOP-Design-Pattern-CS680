package edu.umb.cs680.hw09.ModelABC;

import edu.umb.cs680.hw09.PrintingFramework.Command;
import edu.umb.cs680.hw09.SecurityContext.EncryptedString;
import edu.umb.cs680.hw09.SecurityContext.LoggedIn;
import edu.umb.cs680.hw09.SecurityContext.SecurityContext;

public class PrintJobExecutor extends edu.umb.cs680.hw09.PrintingFramework.PrintJobExecutor {


    @Override
    protected void doAuthentication(EncryptedString encryptedString, SecurityContext context) throws RuntimeException {
        context.login(encryptedString);
        if (context.getState() instanceof LoggedIn) SecurityContext.isActive = true;
        else {
            throw new RuntimeException("Auth Fail, Cannot print");
        }
    }

    @Override
    protected void doAccessControl() {
    }



    @Override
    public void doPrint(Command pj) {
        if (SecurityContext.isActive) {
            pj.execute();
            System.out.println("The print job executed from printer: ABC");
        } else {
            throw new RuntimeException("User is not active");
            //System.out.println("Password wrong");}
        }
    }

        @Override
        protected void doErrorHandling () throws Exception {
        }

        public static void main (String[]args){

        }
    }
