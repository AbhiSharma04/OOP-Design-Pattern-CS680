package edu.umb.cs680.hw09.ModelABC;

import edu.umb.cs680.hw09.PrintJob;
import edu.umb.cs680.hw09.Printer;
import edu.umb.cs680.hw09.SecurityContext.EncryptedString;
import edu.umb.cs680.hw09.SecurityContext.SecurityContext;
import edu.umb.cs680.hw09.SecurityContext.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrintJobExecutorTest {

    PrintJobExecutor pjabc= new PrintJobExecutor();
    SecurityContext ctx= new SecurityContext(new User());

    PrintJob printbanner= new PrintJob();

    EncryptedString password= new EncryptedString();



    @Test
    public void CheckModelABCExecutionWithNull() {
        try {
            pjabc.execute(null, null, ctx);
        }
        catch (Throwable e) {
            assertEquals("Auth Fail, Cannot print",e.getMessage() );
        }
    }

    @Test
    public void CheckModelABCWithNotNullValues() throws Throwable {
        pjabc.execute(printbanner,password,ctx);
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
        assertTrue(prtj instanceof PrintJob);
    }



}