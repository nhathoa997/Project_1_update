package services;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.sql.SQLException;

import static junit.framework.TestCase.assertEquals;

@RunWith(Arquillian.class)
public class AuthenticationTest {
    Authentication auth;
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(Authentication.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Before
    public void init() throws SQLException, ClassNotFoundException {
        auth = new Authentication();
    }

    @Test
    public void authenticate() throws SQLException, ClassNotFoundException {
        assertEquals(true,auth.authenticate("Peter","1234", "customer"));
        assertEquals(true,auth.authenticate("Bob","password", "employee"));
        assertEquals(false,auth.authenticate("Henry","1234", "customer"));
        assertEquals(false,auth.authenticate("Bell","password", "employee"));
    }
}
