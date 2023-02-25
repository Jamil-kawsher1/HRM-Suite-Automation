package testRunner;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
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
    public void doClickOnPIM() throws InterruptedException {
        PimPage pimpage=new PimPage(driver);
        pimpage.doClickOnPIM();
        //watting for 3 sec
        Thread.sleep(3000);
        SoftAssert assret=new SoftAssert();
        String messageActual=driver.findElement(By.className("orangehrm-main-title")).getText();
        String messageExpected="Add Employee";
        assret.assertTrue(messageActual.contains(messageExpected));

    }



    @Test(priority = 2,description = "add Employee ")
    public void addEmployee() throws InterruptedException {
PimPage pimPage=new PimPage(driver);
pimPage.doClickOnPIM();
Thread.sleep(2000);
pimPage.addEmployee();

    }
}
