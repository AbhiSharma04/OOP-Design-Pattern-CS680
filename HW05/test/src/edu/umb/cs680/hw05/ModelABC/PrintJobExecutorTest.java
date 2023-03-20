package edu.umb.cs680.hw05.ModelABC;

import edu.umb.cs680.hw05.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrintJobExecutorTest {

    private static SecurityContext context;
    private static PrintJobExecutor executor;

    @BeforeAll
    public static void initialise() {
        context = new SecurityContext(new User());
        executor = new PrintJobExecutor();
    }

    @Test
    public void doAuth() {
        executor.doAuthentication(new EncryptedString(), context);
        assertTrue(context.getState() instanceof LoggedIn);
    }



}