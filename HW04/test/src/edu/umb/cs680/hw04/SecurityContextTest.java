package edu.umb.cs680.hw04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SecurityContextTest {
    @Test
    public void Logout() {
        SecurityContext ctx = new SecurityContext(new User());
        assertTrue(ctx.getState() instanceof LoggedOut);
    }
    @Test
    public void PerfromLogoutOnLoggedOut() {
        SecurityContext ctx = new SecurityContext(new User());
        ctx.logout();
        assertTrue(ctx.getState() instanceof LoggedOut);
    }
    @Test
    public void PerfromLogoutOnLoggedIn() {
        SecurityContext ctx = new SecurityContext(new User());
        ctx.login(new EncryptedString());
        assertTrue(ctx.getState() instanceof LoggedIn);

    }

    @Test
    public void PerformLoginOnLoggedIn() {
        SecurityContext ctx = new SecurityContext(new User());
        ctx.login(new EncryptedString());
        assertTrue(ctx.getState() instanceof LoggedIn);
    }
    @Test
    public void PerformLoginOnLoggedOut() {
        SecurityContext ctx = new SecurityContext(new User());
        ctx.login(new EncryptedString());
        assertTrue(ctx.getState() instanceof LoggedIn);
    }


}