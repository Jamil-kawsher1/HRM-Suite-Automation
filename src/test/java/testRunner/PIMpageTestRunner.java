package testRunner;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PimPage;
import setup.Setup;

public class PIMpageTestRunner extends Setup {
    @BeforeTest
    public void doLogin(){
        LoginPage login=new LoginPage(driver);
        login.doLogin("Admin","admin123");
    }
//    @Test(priority = 2,description = "Click PIM Click")
    public void doClickOnPIM(){
        PimPage pimpage=new PimPage(driver);
        pimpage.doClickOnPIM();
    }
}
