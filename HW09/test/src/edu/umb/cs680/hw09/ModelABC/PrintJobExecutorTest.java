package edu.umb.cs680.hw09.ModelABC;

import edu.umb.cs680.hw09.PrintingFramework.Command;
import edu.umb.cs680.hw09.SecurityContext.*;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class PrintJobExecutorTest {

    PrintJobExecutor pjabc= new PrintJobExecutor();
    SecurityContext ctx= new SecurityContext(new User(),new EncryptedString ("qwerty"));

    Command printbanner= new PrintJob();

    @Test
    public void CheckModelABCExecutionWithNull() throws Exception {
        try {
            pjabc.execute(null, new EncryptedString("qwerty"), ctx);
        }
        catch (RuntimeException e) {
            assertEquals("Printjob object is null",e.getMessage() );
        }
    }

    @Test
    public void CheckModelABCWithNotNullValues() throws Throwable {
        try{
        pjabc.execute(printbanner, new EncryptedString("qwerty"),ctx);}
        catch (RuntimeException e){
            assertEquals ("The authentication failed",e.getMessage ());
        }
    }


    @Test
    public void CheckModelABCWithWrongPass() throws Throwable {
        try{
            pjabc.execute(printbanner,new EncryptedString("qerty"),ctx);}
        catch (RuntimeException e){
            assertEquals ("The authentication failed",e.getMessage ());
        }
    }



    @Test
    public void checkSingletonPrinter(){
        Printer prt= Printer.getInstance();
        Printer prt1= Printer.getInstance();

        assertEquals(prt,prt1);
    }

    @Test
    public void PrintJobExecuteTest(){
        PrintJob prtj= new PrintJob();
        prtj.execute ();
        assertTrue(prtj instanceof PrintJob);
    }

    @Test
    public void doPrintWhenUserNotActive() throws RuntimeException{
        try{pjabc.doPrint (printbanner);}
        catch (RuntimeException e){
            assertEquals ("User is not active",e.getMessage ());
        }
    }

    @Test
    public void PerfromLogoutOnLoggedOut() {
        ctx.logout();
        assertTrue(ctx.getState() instanceof LoggedOut);
    }

    @Test
    public void PerfromLoginOnLoggedoutWithWrongPass() {
        try{ctx.login(new EncryptedString ("qwrty"));

        assertTrue(ctx.getState() instanceof LoggedIn);}
        catch (RuntimeException e){
            assertEquals ("Failed login",e.getMessage ());
        }

    }

    }