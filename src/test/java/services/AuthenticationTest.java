package services;

import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class AuthenticationTest {
    private Authentication auth;
    @Before
    public void init() throws SQLException, ClassNotFoundException {
        auth = new Authentication();
    }
    @Test
    public void authenticate() throws SQLException, ClassNotFoundException {
        assertEquals(true,auth.authenticate("Bob", "password", "employee"));
        assertEquals(true,auth.authenticate("Henry Dinh", "12345", "customer"));
        assertEquals(false,auth.authenticate("not a customer", "password", "customer"));
        assertEquals(false,auth.authenticate("not an employee", "password", "employee"));

    }

    @Test
    public void testAuthenticate() throws SQLException, ClassNotFoundException {
        assertEquals(true,auth.authenticate("Henry Dinh"));
        assertEquals(false,auth.authenticate("not a customer"));
    }
}