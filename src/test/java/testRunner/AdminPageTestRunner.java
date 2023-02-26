package testRunner;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AdminPage;
import pages.LoginPage;
import setup.Setup;
import utils.Utils;

import java.io.IOException;

public class AdminPageTestRunner extends Setup {
    @BeforeTest
    public void doLogin () {
        LoginPage login = new LoginPage(driver);
        login.doLogin("Admin", "admin123");
    }

    @Test
    public void searchUserInfo () throws IOException, ParseException, InterruptedException {
        AdminPage admin = new AdminPage(driver);

        admin.searchUserInfo();
        Thread.sleep(3000);
        String titleActual = driver.findElements(By.className("oxd-text")).get(14).getText();
        String titleexpected = "Record Found";
        System.out.println(titleActual);
        Assert.assertTrue(titleActual.contains(titleexpected));

    }
}
