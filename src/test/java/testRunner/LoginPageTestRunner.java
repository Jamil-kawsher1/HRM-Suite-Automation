package testRunner;

import org.testng.annotations.Test;
import pages.LoginPage;
import setup.Setup;


public class LoginPageTestRunner extends Setup {
    @Test(priority = 1, description = "Login With invalid Credential")
    public void doLoginWithInvalidCreds () {
        LoginPage login = new LoginPage(driver);
        login.doLoginWithInvalidCreds("Admin1", "Tetete");

    }

    @Test(priority = 2, description = "Login With valid Credential")
    public void doLogin () {
        LoginPage login = new LoginPage(driver);
        login.doLogin("Admin", "admin123");
    }
}
