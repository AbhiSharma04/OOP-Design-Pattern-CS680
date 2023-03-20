package edu.umb.cs680.hw05.ModelXYZ;

import edu.umb.cs680.hw05.EncryptedString;
import edu.umb.cs680.hw05.SecurityContext;

public class PrintJobExecutor extends edu.umb.cs680.hw05.PrintingFramework.PrintJobExecutor {
    @Override
    protected void doAuthentication(EncryptedString password, SecurityContext context) {

    }



    @Override
    protected void doAccessControl()  {

    }

    @Override
    protected void doPrint() {
        System.out.println("Print Job XYZ");

    }

    @Override
    protected void doErrorHandling() {

    }

    public static void main(String[] args) {


    }
}
